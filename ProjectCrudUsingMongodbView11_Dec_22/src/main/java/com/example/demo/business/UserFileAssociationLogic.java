package com.example.demo.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileStorageProperties;
import com.example.demo.common.RandomGUID;
import com.example.demo.common.ZonedDateTimeReadConverter;
import com.example.demo.common.ZonedDateTimeWriteConverter;
import com.example.demo.domain.UserFileAssociation;
import com.example.demo.dto.UserFileAssociationDto;
import com.example.demo.embeded.dto.UserFileMetaData;
import com.example.demo.enums.EntityAssociatedWithFile;
import com.example.demo.enums.UserAttachmentEnum;
import com.example.demo.repository.UserFileAssociationRepository;

@Service
public class UserFileAssociationLogic {

	@Autowired
	private UserFileAssociationRepository userFileAssociationRepository;
	@Autowired
	private FileLogic fileLogic;
	@Autowired
	private FileStorageProperties fileStorageProperties;
	@Autowired
	private LogicUtils logicUtils;
	public static final String FILE_DOWNLOAD_URL = "/resource/fileDownload/user/%s/filename/%s";
	private static final Logger LOGGER = LoggerFactory.getLogger(UserFileAssociationLogic.class);

	public UserFileAssociation addUpdateUserFiles(UserFileAssociationDto request, List<MultipartFile> files) {

		if (Objects.nonNull(request.getGlobalId())) {
			UserFileAssociation response = this.userFileAssociationRepository.findById(request.getGlobalId()).get();

			return addFilesToExistingChecklistFileAssociation(request, files, response);
		}
		return saveChecklistFileAssociationWithoutGlobalGuid(request, files);

	}

	public UserFileAssociation saveChecklistFileAssociationWithoutGlobalGuid(UserFileAssociationDto request,
			List<MultipartFile> files) {
		UserFileAssociation userAssociation = new UserFileAssociation();
		String globalId = new RandomGUID().toString();
		if (Objects.nonNull(request.getAddedFiles()) && !request.getAddedFiles().isEmpty()) {
			List<UserFileMetaData> metadata = addFiles(request.getAddedFiles(), files, globalId);
			userAssociation.setFiles(metadata);
			userAssociation.setId(globalId);
			userAssociation.setUsed(false);
			userAssociation.setUserName("radhikamendhe@gmail.com");
			 userAssociation.setCreatedAt(new DateTime());
			 userAssociation.setUpdatedAt(new DateTime());
			// eventPublisher.publishEvent(new
			// ChecklistFileAdded(this.userSecurityUtils.getCurrentUserActor(0),
			// checklistAssociation, metadata.get(0).getInternalFileName()));
		}
		return this.userFileAssociationRepository.save(userAssociation);
	}

	public UserFileAssociation addFilesToExistingChecklistFileAssociation(UserFileAssociationDto request,
			List<MultipartFile> files, UserFileAssociation response) {

		if (Objects.nonNull(request.getRemovedFiles()) && !request.getRemovedFiles().isEmpty()) {
			request.getRemovedFiles()
					.forEach(file -> response.getFiles().removeIf(a -> a.getInternalFileName().equals(file)));
		}
		if (Objects.nonNull(request.getAddedFiles()) && !request.getAddedFiles().isEmpty()) {
			List<UserFileMetaData> metadata = addFiles(request.getAddedFiles(), files, request.getGlobalId());
			response.getFiles().addAll(metadata);
		}
		 response.setUpdatedAt(new DateTime());

		this.userFileAssociationRepository.save(response);
		return response;
	}

	public List<UserFileMetaData> addFiles(List<String> fileNames, List<MultipartFile> files, String globalId) {
		List<UserFileMetaData> response = new ArrayList<>();
		if (Objects.nonNull(fileNames) && Objects.nonNull(files)) {
			for (int i = 0; i < files.size(); i++) {
				UserFileMetaData userMetaData = new UserFileMetaData();
				String internalFileName = new RandomGUID().toString() + fileNames.get(i);
				String filePathName = this.fileLogic.findAvailableFileName(internalFileName,
						EntityAssociatedWithFile.USER_FILES);
				filePathName = filePathName.replace("\"", "");
				userMetaData.setFileName(fileNames.get(i));
				userMetaData.setInternalFileName(internalFileName);
				userMetaData.setUserAttachmentEnum(UserAttachmentEnum.DRAFTED);
				try {
					this.fileLogic.writeFile(files.get(i).getBytes(), filePathName);
				} catch (IOException e) {
					LOGGER.error("Checklist:: upload File ERROR:: ", e);
				}

				try {
					Path source = Paths.get(this.fileStorageProperties.getUserFileDirectory(), internalFileName);
					String mimeType = Files.probeContentType(source).toUpperCase();
					userMetaData.setMimeType(mimeType);
				} catch (Exception e) {
					LOGGER.error("Checklist:: file mimetype ERROR:: ", e);
				}

				String filePath = String.format(FILE_DOWNLOAD_URL, globalId, internalFileName);
				userMetaData.setFileUrl(filePath);

				long bytes = files.get(i).getSize();
				userMetaData.setFileSize(bytes);
				ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
				// ZonedDateTimeReadConverter now2 = new ZonedDateTimeReadConverter();
				// ZonedDateTime a = now2.convert(new Date());
				ZonedDateTimeWriteConverter now = new ZonedDateTimeWriteConverter();
				Date date = now.convert(zonedDateTime);
				System.out.println("/////////////" + date);
				userMetaData.setUploadTime(date);
				response.add(userMetaData);
			}
		}
		return response;
	}

	public UserFileAssociation loadUserFiles(String id) {
		if (Objects.isNull(id))
			return null;
		Optional<UserFileAssociation> optional = userFileAssociationRepository.findById(id);

		if (!optional.isPresent())
			// throw new IllegalArgumentException(logicUtils.getIllegalGuidMessage(id));
			// throw new IllegalArgumentException(logicUtils.getPowerBiUrlExpired());
			throw new IllegalArgumentException("An invalid object identity was specified"+id);

		return optional.get();
	}

	public List<UserFileAssociation> getUserFileAssociationList() {

		return userFileAssociationRepository.findAll();
	}
	
	public UserFileAssociation removeCheckListFile(String internalFileName) {
		UserFileAssociation response = this.userFileAssociationRepository.findByFiles_InternalFileName(internalFileName);
		if (Objects.nonNull(response)) {
			response.getFiles().removeIf(a -> a.getInternalFileName().equals(internalFileName));
			userFileAssociationRepository.save(response);
		}
		return response;
	} 
	
}
