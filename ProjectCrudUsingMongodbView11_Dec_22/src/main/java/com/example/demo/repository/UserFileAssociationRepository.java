package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.UserFileAssociation;

public interface UserFileAssociationRepository extends MongoRepository<UserFileAssociation, String>{

}
