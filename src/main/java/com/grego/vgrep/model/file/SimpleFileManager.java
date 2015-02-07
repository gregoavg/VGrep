/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file;

import java.util.EnumMap;
import java.util.Map;

import static com.grego.vgrep.model.file.ADataFile.getEmptyDataFile;

/**
 * Simple implementation of <code>IFileManager</code>, defined by a map of 
 * data files to their labels. This map has an entry set, with size defined by
 * the number of enumerable labels that this application models.
 * 
 * @author Grigorios
 */
public final class SimpleFileManager implements IFileManager {

    private final Map<EDataLabel, ADataFile> contentMapper = new EnumMap<>(EDataLabel.class);

    @Override
    public void addFile(EDataLabel dataLabel, ADataFile dataFile) {
        contentMapper.put(dataLabel, dataFile);
    }

    @Override
    public void remove(EDataLabel dataLabel) {
        contentMapper.remove(dataLabel);
    }
    
    @Override
    public ADataFile getFile(EDataLabel dataLabel) {
        return contentMapper.containsKey(dataLabel) 
                ? contentMapper.get(dataLabel) : getEmptyDataFile();
    }

    @Override
    public void removeAll() {
        contentMapper.clear();
    }

}
