/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file;

import com.grego.vgrep.model.data.AData;

/**
 *
 * @author grigo_000
 */
public interface IDataManager {

    void addData(EDataType dataType, AData data);
    
    void remove(EDataType dataType);
    
    AData getData(EDataType dataType);
    
    void clearData();
    
}
