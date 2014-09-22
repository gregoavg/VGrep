/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.model.data.ADataFile;

/**
 *
 * @author Grigorios
 */
public interface IComponentHandler {
    
    void setDataModel(ADataFile data);
    
    ADataFile getDataModel();
    
    Object getComponent();
    
}