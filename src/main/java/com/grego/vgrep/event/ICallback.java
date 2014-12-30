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
    
    void onReturn(T data);
    
}
