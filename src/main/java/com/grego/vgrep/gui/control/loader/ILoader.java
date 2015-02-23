/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control.loader;

import com.gregoavg.viewmanager.event.ICallable;

/**
 * Representer for instances responsible to load external information to objects.
 * This interface extends and makes use of callable interface, in order to
 * update loader into callback caller. As callback caller, loader can provide
 * the emerged object to clients, by invoking the referenced callback method.
 *
 * @author    Grego
 *
 * @param <T> the type of object that needs internal loading.
 * @param <R> the type of object that loader returns to clients
 *            through callback.
 */
public interface ILoader<T, R> extends ICallable<R> {

    /**
     * Loads information to a given instance.
     * 
     * @param obj the instance to be loaded.
     *
     */
    void loadFrom(T obj);
    
}
