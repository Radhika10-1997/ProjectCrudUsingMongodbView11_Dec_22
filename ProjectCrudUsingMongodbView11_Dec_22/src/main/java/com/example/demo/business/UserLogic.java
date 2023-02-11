package com.example.demo.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.data.document.ContactRepository;
import com.example.demo.data.document.UserRepository;
import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserLogic {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogic.class);

	public User save(User user) {
		return  userRepository.save(user);		
	}	

	public List<User> getAllUser() {
		List<User> p= userRepository.findAll();
		//List<Integer> q4= new ArrayList<>();
		//q4.add(0);
		//List<User> q1= (List<User>)userRepository.findAllById(q4);
		User q3= userRepository.findById(3);
		//p.removeIf(l->l.getId()==2);			
		p.removeIf(l->l.getId()==q3.getId());
		 return p;
	}
	
	
/*
	public User deleteUser(int id) {
		return userRepository.deleteById(id);
	}
	
	public Boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		//System.out.println(userRepository.deleteById(id)+" "+"gggggggggggggg");
		return userRepository.deleteById(id);
	}
	*/	
	
	public void deleteUser(int id) {
		//System.out.println(userRepository.deleteById(id)+" "+"gggggggggggggg");
		 userRepository.deleteById(id);
	}

	public User updateUser(User user) {
		User u=userRepository.findById(user.getId());
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		userRepository.save(u);
		return u;
	}
	
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);		
	}
	
	public List<Contact> getAllContact() {
		List<Contact> p= contactRepository.findAll();
		List<Integer> q4= new ArrayList<>();
		q4.add(4);
		List<Integer> q5= new ArrayList<>();
		q5.add(0);
	    List<Contact> q1= (List<Contact>)contactRepository.findAllById(q5);
		List<Contact> o = (List<Contact>) contactRepository.findAllById(q4);
		//way1
		p.removeAll(o);
		//way2
		 for(Contact o1:o) {
		    p.removeIf(l->l.getId()==o1.getId());
		}
		//way3
		 List<Contact> c = new ArrayList<>();
		 for(Contact qr:q1) {
		c = p.stream().filter(l->l.getId()!=qr.getId()).map(l1->l1).collect(Collectors.toList());
		//p.removeIf(l->l.equals(qr.getId()));
		//p.removeIf(qr::equals);		 
		//p.removeIf(l->q1.contains(l));			
				//.contains(qr.getId()));
		//equal method will not work here because it return true when object equals false 0 0 false 3 0		
		//p.forEach(l->{System.out.println(l.equals(qr.getId())+" "+l.getId()+" "+qr.getId());});
		 }
		 return c;
		 //return c;
	}
	
	public List<User> getallUserlist(){		
		return userRepository.findAll();		
	}
	
	public Map<Integer, Contact> getallContactlist(List<User> userList) {
		List<Integer> idList = userList.stream().map(l -> l.getId()).collect(Collectors.toList());
		List<Contact> contactList = (List<Contact>) contactRepository.findAllById(idList);
		Map<Integer, Contact> conMap = contactList.stream()
				.collect(Collectors.toMap(Contact::getId, Function.identity()));
		return conMap;

	}

	public User getUserByIdAndUserName(int id, String userName) {
		return userRepository.findparameter(id, userName);

	}

	public Contact getContactByIdAndUserName(int id, String userName) {
		return contactRepository.findContact(id, userName);

	}
	
	public List<User> getSortedUser() {
		Sort sort = Sort.by(Sort.Direction.ASC, "_id");
		List<User> listU = userRepository.findAll();
		Sort sort1 =Sort.by(Sort.Order.asc("_id"));
		Sort sort3 =Sort.by(Sort.Order.desc("_id"));
		Sort sort4 =Sort.by(Sort.Order.by("_id"));
	    Sort sort2 =Sort.by("_id");
		System.out.println(sort+" "+"hhhhhhhh"+sort1+"lllll"+sort2+"kkk"+sort3+"hhhh"+sort4);
		List<Integer> uids = userRepository.findAll().stream().map(l->l.getId()).collect(Collectors.toList());
		//return userRepository.FindSortedUser(uids,sort);
		return userRepository.findByIdIn(uids,sort);
	}

	public void deleteUserById(int id) {
		userRepository.deleteUserById(id);		
	}

	public User getUserByUserName(String userName) {		
		return userRepository.findByUserName(userName);
	}

	public User getUserByIdAndUserName1(int id, String userName) {
	//	return  userRepository.findByIdAndUserName(id,userName);
		//return  userRepository.findUserByIdAndUserNames(id,userName);
		return  userRepository.findByIdAndUserName(id,userName);
	}

	public List<User> updateUserDetail(User user) {		
		return userRepository.updateUser(user.getId(),user.getPassword(),user.getUserName());
	}

	public String getContactById(int id) throws JsonProcessingException {
		// ObjectMapper m = new ObjectMapper();
		ObjectMapper m = new ObjectMapper();
		/*
		 * working condition
		 * 
		 * if (Objects.nonNull(c) && Objects.nonNull(c.getUserName())) { return c; }
		 */
		try {
			Contact c = contactRepository.findContactById(id);

		//	if (!Objects.isNull(c)) {
			//	return null;
			
//if()
			return m.writeValueAsString(c.getUserName());
			//}
		} catch (Exception e) {
			LOGGER.error("UiNotificationReceiver::sendMessageToProject9999999999999999999999999999", e);
			return m.writeValueAsString(Set.of());
		}

	}
	
	public Contact getContactById1(int id)  throws Exception  {		
		/*
		 * working condition
		 * 
		 * if (Objects.nonNull(c) && Objects.nonNull(c.getUserName())) { return c; }
		 */
		
	/*		Contact c = contactRepository.findContactById(id);
			if(Objects.nonNull(c)) {				
	          return c;
			}else {
				throw new IllegalArgumentException("UiNotificationReceiver::sendMessageToProject9999999999999999999999999999");
			}*/
		
		Contact c = contactRepository.findContactById(id);
		if(Objects.nonNull(c)) {	
			try {
			String a= c.getUserName();	
			if(Objects.nonNull(c.getUserName())) {
			Contact c1 = contactRepository.findContactByUserName(a);
			}
          return c;}catch (Exception e) {
  			LOGGER.error("UiNotificationReceiver::sendMessageToProject11111111", e);
  			return null;
  		}
		}else {
			throw new IllegalArgumentException("UiNotificationReceiver::sendMessageToProject9999999999999999999999999999");
		}
		

	}

	
	

	// throws IOException 
	/*
	 * if(!file.isEmpty()) {
            if(filename.isEmpty()) {
                filename = file.getOriginalFilename();
            }
            String json = this.activityService.uploadActivityFile(file, filename, activityId,
                    tagUsers);
            ObjectMapper m = new ObjectMapper();
            Map<String, Object> resp = new HashMap<>();
            resp.put("name", filename);
            resp.put("state", true);
            resp.put("message", json);
            return m.writeValueAsString(resp);
        } else {
            throw new IllegalArgumentException(this.messageSource.getMessage("no.file.content",
                    null, LocaleContextHolder.getLocale()));
        }
	 */
}
