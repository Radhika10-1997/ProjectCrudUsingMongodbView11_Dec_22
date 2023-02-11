package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* Base class for all DTO objects. This defines the guid property that will be
* used to identify the object in the client.
* 
* @author Radhika Mendhe
*
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DtoBase {

   protected String guid;

   public void setGuid(String guid) {

       this.guid = guid;
   }

   public String getGuid() {

       return this.guid;
   }
}

