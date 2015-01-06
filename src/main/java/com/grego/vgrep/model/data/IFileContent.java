/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data;

import java.util.List;

/**
 * Represents the content of a data file and methods to effectively access that.
 * 
 * @author Grigorios
 * @param <T> type of elements in this content
 */
public interface IFileContent<T> {
    
    /**
     * Returns all the elements of this content, transformed to be ready 
     * for the compare process with elements of the same type. 
     * 
     * @return list of elements
     */
    List<Comparable> list();
    
    /**
     * Returns a single element of the content, that is indexed on the exact
     * combination of row and column.
     * 
     * @param rowIndex
     * @param columnIndex
     * @return indexed element
     */
    T getElementAt(int rowIndex, int columnIndex);
}
