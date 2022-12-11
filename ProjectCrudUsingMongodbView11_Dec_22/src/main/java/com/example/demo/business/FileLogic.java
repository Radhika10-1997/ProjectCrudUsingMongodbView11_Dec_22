package com.example.demo.business;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.FileStorageProperties;
import com.example.demo.common.FileUtils;
import com.example.demo.common.FilenameUtils;
import com.example.demo.enums.EntityAssociatedWithFile;

@Component
@Transactional(value = "neo4jTransactionManager", readOnly = true)
public class FileLogic {
	
	@Autowired
	private FileStorageProperties fileStorageProperties; 
	
	  public void writeFile(byte[] fileBytes, String filePathName) throws IOException {

	        FileUtils.writeByteArrayToFile(new File(filePathName), fileBytes);
	    }
	  
	 public String doGetFilename(String StorageDirectory, String fullFileName) {

	        Path path = Paths.get(StorageDirectory, fullFileName);
	        if(!Files.exists(path))
	            return path.toString();

	        String extension = FilenameUtils.getBaseName(fullFileName);
	        String baseName = FilenameUtils.getBaseName(fullFileName);

	        for(int i = 0; i < Integer.MAX_VALUE; i++) {
	            path = Paths.get(StorageDirectory, String.format("%s%d.%s", baseName, i, extension));
	            if(!Files.exists(path)) {
	                return path.toString();
	            }
	        }
	        throw new IllegalStateException(
	                "No valid filename could be generated for the base file name " + fullFileName);
	    }
	  /*
     * Rename file to a new name adding a number to the name if the file exists
     * in a give directory
     */
    public String findAvailableFileName(String fullFileName,
            EntityAssociatedWithFile fileAssociation) {

        if(EntityAssociatedWithFile.PERSON == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getProfileImageDirectory(),
                    fullFileName);
        } else if(EntityAssociatedWithFile.ACTIVITY == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getActivityFileDirectory(),
                    fullFileName);
        } else if(EntityAssociatedWithFile.CUSTOMER == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getCustomerFileDirectory(),
                    fullFileName);
        } else if(EntityAssociatedWithFile.CONSTRAINT_LOG == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getConstraintLogFileDirectory(),
                    fullFileName);
        }else if(EntityAssociatedWithFile.CHECKLIST_FILES == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getChecklistFileDirectory(),
                    fullFileName);
        }else if(EntityAssociatedWithFile.USER_FILES == fileAssociation) {
            return this.doGetFilename(this.fileStorageProperties.getChecklistFileDirectory(),
                    fullFileName);
        }
        else {
            throw new IllegalArgumentException(
                    "EntityAssociatedWithFile must be one of ACTIVITY, PERSON or CUSTOMER for file locations to be resolved");
        }
    }
}
