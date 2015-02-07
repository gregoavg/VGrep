/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file;

import java.util.Collections;
import java.util.List;

/**
 * Represents the content of a data and methods to effectively access that.
 * 
 * @author Grigorios
 * @param <T> type of elements in this content
 */
public interface IContent<T> {
    
    /**
     * Returns all the elements of this content, transformed to be ready 
     * for the compare process with elements of the same type. 
     * 
     * @return list of elements
     */
    List<T> list();

    /**
     * Returns a single element of the content, that is indexed on the exact
     * combination of row and column.
     * 
     * @param rowIndex      index of row that contains the element
     * @param columnIndex   index of column that contains the element
     * @return              indexed element of the exact row-col combination
     */
    <E> E getElementAt(int rowIndex, int columnIndex);


    /**
     * Provides an empty implementation of this interface.
     *
     * @return empty implementation
     */
    static <E> IContent<E> empty() {
        return new IContent<E>() {
            @Override
            public List<E> list() {
                return Collections.emptyList();
            }

            @Override
            public Object getElementAt(int rowIndex, int columnIndex) {
                return new Object();
            }
        };
    }
}
