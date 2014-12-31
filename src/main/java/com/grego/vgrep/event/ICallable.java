/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

/**
 *
 * @author Grego
 * @param <T>
 */
public interface ICallable<T> {
    
    void setCallback(ICallback<T> callback);
}
