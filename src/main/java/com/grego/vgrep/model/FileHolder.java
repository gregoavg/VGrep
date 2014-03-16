/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import com.grego.vgrep.model.reader.EFileType;
import com.grego.vgrep.utils.FileUtils;
import java.io.File;
import java.util.Objects;

/**
 *
 * @author grigo_000
 */
public final class FileHolder implements IFileHolder {

    private File file = null;
    
    @Override
    public EFileType getFileType() {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.file);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final FileHolder other = (FileHolder) obj;
        if (!Objects.equals(this.file, other.file))
        {
            return false;
        }
        return true;
    }
    
    
    
}
