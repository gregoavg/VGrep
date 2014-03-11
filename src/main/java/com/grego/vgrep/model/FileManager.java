/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author grigo_000
 */
public final class FileManager implements IFileManager {

    private final Map<EContentType, IFileHolder> contentMapper = new HashMap<>(2);

    public FileManager() {
        contentMapper.put(EContentType.INFO, new FileHolder());
        contentMapper.put(EContentType.TARGET, new FileHolder());
    }

    @Override
    public void setFile(EContentType contentType, File file) {
        contentMapper.get(contentType).setFile(file);
    }

    @Override
    public IFileHolder getFileHolder(EContentType contentType) {
        return contentMapper.get(contentType);
    }
    
    @Override
    public void clearFiles() {
        for(Entry entry : contentMapper.entrySet()) {
            ((IFileHolder) entry.getValue()).removeFile();
        }
    }

    @Override
    public void removeFile(File file) {
        for(IFileHolder entry : contentMapper.values()) {
            if(entry.getFile().equals(file))
            {
                entry.removeFile();
            }
        }
    }
}
