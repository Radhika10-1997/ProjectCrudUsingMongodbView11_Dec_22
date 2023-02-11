package com.example.demo.data.graph;


/**
 * All entities in the VisiLean system that we wish to uniquely identify should
 * implement this interface
 * 
 * @author Radhika Mendhe
 * 
 */
public interface IIdentifiable {

    /**
     * Gets the unique Idnetity property for the object
     * 
     * @return Globally unique identity string for the object
     */
    public String getGuid();
}

