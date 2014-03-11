/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import java.io.File;

/**
 *
 * @author grigo_000
 */
public interface IFileManager {

    void setFile(EContentType contentType, File file);
    
    void removeFile(File file);
    
    IFileHolder getFileHolder(EContentType contentType);
    
    void clearFiles();
    
}
