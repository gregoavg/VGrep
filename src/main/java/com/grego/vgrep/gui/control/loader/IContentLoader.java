/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control.loader;

import com.grego.vgrep.event.ICallback;
import com.grego.vgrep.model.data.ADataFile;

/**
 *
 * @author Grego
 */
public interface IContentLoader {
    
    void setCallBack(ICallback callback);
    
    void loadFrom(ADataFile file);
    
}
