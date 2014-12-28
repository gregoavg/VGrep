/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data;

import java.util.List;

/**
 *
 * @author Grigorios
 * @param <T> type of elements in this content
 */
public interface IFileContent<T> {

    List<Comparable> list();
    
    T getElementAt(int lineIndex, int rowIndex);
}
