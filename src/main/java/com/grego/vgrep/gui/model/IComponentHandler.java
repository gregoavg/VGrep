/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.model.holder.IHolder;

import java.util.List;

/**
 * Represents a manager for view components.
 * 
 * @author Grigorios
 * @param <T> the type of component that it handles.
 * @param <M> the type of the model data used as feed
 *            for the component.
 */
public interface IComponentHandler<T, M> {
   
    /**
     * Provides necessary model data to the component handler.
     * 
     * @param model the data to be used as feed for the component.
     */
    void setModel(M model);
    
    /**
     * Informs clients about the model of the displayed data.
     * 
     * @return the model data of this component.
     */
    M getModel();
    
    /**
     * Returns the component that this handler holds.
     * 
     * @return the component being handled.
     */
    T getComponent();
    
    /**
     * Returns  the user selected values
     *
     * @param   <E> type of selected values
     * @return  list of values or <b>empty list</b> if nothing is selected.
     * @see     IHolder
     */
    <E> List<E> getSelectedValues();
    
}
