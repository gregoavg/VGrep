/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data;

import java.util.Map;
import static com.grego.vgrep.model.data.ADataFile.getEmptyDataFile;
import java.util.EnumMap;

/**
 *
 * @author Grigorios
 */
public final class SimpleFileManager implements IFileManager {

    private final Map<EDataType, ADataFile> contentMapper = new EnumMap<>(EDataType.class);

    @Override
    public void addFile(EDataType dataType, ADataFile dataFile) {
        contentMapper.put(dataType, dataFile);
    }

    @Override
    public void remove(EDataType dataType) {
        contentMapper.remove(dataType);
    }
    
    @Override
    public ADataFile getFile(EDataType dataType) {
        return contentMapper.containsKey(dataType) 
                ? contentMapper.get(dataType) : getEmptyDataFile();
    }

    @Override
    public void clearData() {
        contentMapper.clear();
    }

}
