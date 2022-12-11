package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.StringOperators.Concat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.UserLogic;
import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.dto.UserContactDto;
import com.example.demo.dto.service.UserContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
//this controller use all mongodb operation for USER and CONTACT
@RestController
public class UserController {

	@Autowired
	private UserLogic userService;

	@Autowired
	private UserContactService userContactService;

	@PostMapping("/user")
	private User SaveUser(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/userlist")
	private List<User> getAllUser() {
		return userService.getAllUser();
	}
	/*
	 * @DeleteMapping("/userdelete/{id}") private User deleteUser(@PathVariable int
	 * id) { return userService.deleteUser(id); }
	 * 
	 * @DeleteMapping("/userdelete/{id}") private Boolean
	 * deleteUserboolean(@PathVariable int id) { return userService.deleteUser(id);
	 * }
	 */

	@DeleteMapping("/userdelete/{id}")
	private void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

	@PutMapping("/userupdate")
	private User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@PostMapping("/saveContact")
	private Contact saveContact(@RequestBody Contact contact) {
		return userService.saveContact(contact);
	}

//get all caontact by removing specific contact
	@GetMapping("/getAllContact")
	private List<Contact> getAllContact() {
		return userService.getAllContact();

	}

//get user data with contact 	
	@GetMapping("/getAllUserWithContact")
	private List<UserContactDto> getAllUserWithContact() {
		List<User> userList = userService.getallUserlist();
		Map<Integer, Contact> contactMap = userService.getallContactlist(userList);
		return userContactService.toDtos(userList, contactMap);
	}

	@GetMapping("/getUserWithContact/{id}/{userName}")
	private UserContactDto getUserContact(@PathVariable int id, @PathVariable String userName) {
		User u = userService.getUserByIdAndUserName(id, userName);
		Contact c = userService.getContactByIdAndUserName(u.getId(), u.getUserName());
		return userContactService.toDto(u, c);

	}
//Sort sort = Sort.by(Sort.Direction.ASC, "_id");
//@Query(value = "{'userId':{$in:?0}}")
//public List<UserAccountRecord> findSortedUserIds(List<String> userIds, Sort sort);

//get sorted result
	@GetMapping("/getSortedUser")
	private List<User> getSortedUser() {
		return userService.getSortedUser();
	}

//delet user
	@DeleteMapping("/deleteUser/{id}")
	private void deleteUserById(@PathVariable int id) {
		userService.deleteUserById(id);
	}

	@GetMapping("/getUser/{userName}")
	private User getUserByUserName(@PathVariable String userName) {
		return userService.getUserByUserName(userName);
	}

	/*@GetMapping("/getUser/{id}/{userName}")
	private User getUserByIdAndUserName(@PathVariable int id, @PathVariable String userName) {
		return userService.getUserByIdAndUserName1(id, userName);
	}*/
	//not working try to investigation
	@PutMapping("/updateUser")
	private List<User> updateUserDetail(@RequestBody User user) {
		return userService.updateUserDetail(user);
		
	}
	@GetMapping("/getUser/{id}/{userName}")
	private ResponseEntity getUserByIdAndUserName(@PathVariable int id, @PathVariable String userName) {
		return ResponseEntity.ok(userService.getUserByIdAndUserName1(id, userName));
	}
	//try catch use
	@GetMapping("/getContactById/{id}")
	private String getContactById(@PathVariable int id) throws JsonProcessingException
	{
		return userService.getContactById(id);
		
	}
	//try catch and throw
	@GetMapping("/getContactBy/{id}")
	private Contact getContactById1(@PathVariable int id)  throws Exception 
	{
		return userService.getContactById1(id);
		
	}
}
