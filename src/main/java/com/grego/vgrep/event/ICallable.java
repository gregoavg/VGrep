/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

/**
 * Represents a caller who is capable of executing it's operations with callbacks.
 * A callback can be invoked by this representer whenever the event process
 * demands it.
 * 
 * @author Grego
 * @param <T> type of data that this caller will provide on it's callback.
 * 
 */
public interface ICallable<T> {
    
    /**
     * Sets a callback for this caller
     * 
     * @param callback the callback to be called by this caller
     * @see ICallback
     * 
     */
    void setCallback(ICallback<T> callback);
}
