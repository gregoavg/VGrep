/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.model.holder.IHolder;
import com.grego.vgrep.model.data.ADataFile;
import java.util.List;

/**
 * Represents a manager for view components.
 * 
 * @author Grigorios
 */
public interface IComponentHandler {
   
    /**
     * Provides necessary model data to the component handler.
     * 
     * @param data model to be presented.
     * @see   ADataFile
     * 
     */
    void setDataModel(ADataFile data);
    
    /**
     * Informs clients about the model of the displayed data.
     * 
     * @return displayed data model
     * @see    ADataFile
     * 
     */
    ADataFile getDataModel();
    
    /**
     * Returns the component that this manager holds.
     * 
     * @return the component being managed
     * 
     */
    Object getComponent();
    
    /**
     * Returns the user selected values
     * 
     * @return list of values wrapped in a holder or 
     *         <b>empty list</b> if nothing is selected.
     * @see    IHolder
     * 
     */
    List<IHolder> getSelectedValues();
    
}
