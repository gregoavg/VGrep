/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import com.grego.vgrep.model.reader.EFileType;
import java.io.File;

/**
 *
 * @author grigo_000
 */
public interface IFileHolder {
    
    public EFileType getFileType();
    
    public void setFile(File file);
    
    public File getFile();
    
    public void removeFile();
    
    public boolean hasFile();
    
}
