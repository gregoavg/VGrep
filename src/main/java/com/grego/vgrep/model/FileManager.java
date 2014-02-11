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
    public IFileHolder getInfoFileHolder() {
        return contentMapper.get(EContentType.INFO);
    }

    @Override
    public IFileHolder getTargetFileHolder() {
        return contentMapper.get(EContentType.TARGET);
    }

    @Override
    public void setInfoFile(File infoFile) {
        contentMapper.get(EContentType.INFO).setFile(infoFile);
    }

    @Override
    public void setTargetFile(File targerFile) {
        contentMapper.get(EContentType.TARGET).setFile(targerFile);
    }

    @Override
    public void removeFiles() {
        for(Entry entry : contentMapper.entrySet()) {
            ((IFileHolder) entry.getValue()).removeFile();
        }
    }
}
