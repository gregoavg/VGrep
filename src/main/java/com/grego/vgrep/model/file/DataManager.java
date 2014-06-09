/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file;

import com.grego.vgrep.model.data.AData;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Grigorios
 */
public final class DataManager implements IDataManager {

    private final Map<EDataType, AData> contentMapper = new HashMap<>(2);
    
    @Override
    public void addData(EDataType dataType, AData data) {
        contentMapper.put(dataType, data);
    }

    @Override
    public void remove(EDataType dataType) {
        contentMapper.remove(dataType);
    }

    @Override
    public AData getData(EDataType dataType) {
        return contentMapper.get(dataType);
    }

    @Override
    public void clearData() {
        contentMapper.clear();
    }
    
}
