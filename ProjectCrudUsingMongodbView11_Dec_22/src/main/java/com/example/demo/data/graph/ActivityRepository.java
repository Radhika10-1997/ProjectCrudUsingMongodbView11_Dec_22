package com.example.demo.data.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demo.domain.Activity;

public interface ActivityRepository extends Neo4jRepository<Activity, Long>{

}
