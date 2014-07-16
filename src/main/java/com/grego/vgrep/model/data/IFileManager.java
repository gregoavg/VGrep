/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data;

/**
 *
 * @author grigo_000
 */
public interface IFileManager {

    void addFile(EDataType dataType, ADataFile dataFile);
    
    ADataFile getFile(EDataType dataType);
    
    void remove(EDataType dataType);
    
    void clearData();
    
}
