/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data;

/**
 * Represents a manager for <code>ADataFile</code>. It is able to append,
 * retrieve and remove data files.
 * 
 * @author Grego
 * 
 */
public interface IFileManager {

    /**
     * Provides a file, of a particular label, to the manager.
     * 
     * @param dataLabel 
     * @param dataFile file to be stored
     * @see EDataLabel
     * @see ADataFile
     * 
     */
    void addFile(EDataLabel dataLabel, ADataFile dataFile);
    
    /**
     * Retrieves a file of a particular label
     * 
     * @param dataLabel type of usage 
     * @return data file
     * @see EDataLabel
     * 
     */
    ADataFile getFile(EDataLabel dataLabel);
    
    /**
     * Removes file of a particular label
     * 
     * @param dataLabel type of usage 
     * @see EDataLabel
     * 
     */
    void remove(EDataLabel dataLabel);
    
    /**
     * Removes all stored files.
     * 
     */
    void removeAll();
    
}
