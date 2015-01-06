/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

/**
 *
 * @author Grego
 * @param <T> type of data provided from the callback clients
 * when they invoke onReturn method.
 */
@FunctionalInterface
public interface ICallback<T> {
    
    /**
     * Invokes the callback method defined at client, with data provided by the caller.
     * 
     * @param data the provided data that emerged after caller side operations.
     * 
     */
    void onReturn(T data);
    
}
