/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import com.grego.vgrep.control.PersistanceType;
import com.grego.vgrep.utils.FileUtils;
import java.io.File;

/**
 *
 * @author grigo_000
 */
public final class FileHolder implements IFileHolder {

    private File file;

    public FileHolder() {
        this.file = null;
    }
    
    public FileHolder(File file) {
        this.file = file;
    }
    
    @Override
    public PersistanceType getFileType() {
        return FileUtils.getFileType(file);
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public void removeFile() {
        this.file = null;
    }

    @Override
    public boolean hasFile() {
        return file != null;
    }
    
}
