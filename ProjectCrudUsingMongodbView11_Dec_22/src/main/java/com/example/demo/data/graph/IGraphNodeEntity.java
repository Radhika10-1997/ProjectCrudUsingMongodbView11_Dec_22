package com.example.demo.data.graph;


import org.springframework.data.neo4j.core.schema.Node;

/**
 * Defines the methods required of any object wishing to be stored into the
 * graph database.
 * 
 * @author Radhika Mendhe
 */
@Node
public interface IGraphNodeEntity {

    /**
     * Gets the identity by which the object is known to the graph database.
     */
    public Long getGraphId();

    /**
     * Sets the identity by which the object will be known within the graph
     * database. Should not be set externally.
     */
    public void setGraphId(Long nodeId);
}
