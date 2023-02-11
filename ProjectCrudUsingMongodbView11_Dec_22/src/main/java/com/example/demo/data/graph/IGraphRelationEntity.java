package com.example.demo.data.graph;

/**
 * Base interface for all relationships
 * 
 * @author Radhika Mendhe
 */
public interface IGraphRelationEntity<TStart extends IGraphNodeEntity, TEnd extends IGraphNodeEntity>
        extends IIdentifiable {

    /**
     * Gets the identity by which the object is known to the graph database.
     */
    public Long getGraphId();

    /**
     * Sets the identity by which the object will be known within the graph
     * database. Should not be set externally.
     */
    public void setGraphId(Long nodeId);

    /**
     * Sets the unique ID of this object. Introduced after we had to remove the
     * relation hierarchy due to the constraints of the Neo4j OGM.
     */
    public void setGuid(String guid);

    public String getType();

    public void setType(String type);

    public TStart getStart();

    public void setStart(TStart start);

    public TEnd getEnd();

    public void setEnd(TEnd end);
}

