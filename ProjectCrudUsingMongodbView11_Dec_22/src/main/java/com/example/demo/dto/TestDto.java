//package com.example.demo.dto;
//
//import lombok.Data;
//
//@Data
//public class TestDto {
//	
//}List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
//
//
//    
//
//
//
//
//
//
//// Enables the distinct flag for the query
//List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
//List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
//
//// Enabling ignoring case for an individual property
//List<Person> findByLastnameIgnoreCase(String lastname);
//// Enabling ignoring case for all suitable properties
//List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
//
//// Enabling static ORDER BY for a query
//List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
//List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
//
//
//
//
//
//
//
//
//@RequestMapping(value = ActivityUrls.V2.Get.PROJECT_ACTIVITIES_PROGRESS,
//method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//public @ResponseBody Integer getTotalProjectProgress(
//@RequestParam(ActivityUrls.RequestParams.PROJECT_GUID) String projectGuid) {
//
//return this.activityService.getTotalProjectProgress(projectGuid);
//}
//
//
//
