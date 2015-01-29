/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.holder;

/**
 * Simple implementation of <code>IHolder</code>, with one value as a private
 * class field.
 *
 * @author Grigorios
 * @param <V> type of the holed value.
 */
public final class SimpleHolder<V> implements IHolder<V> {

    private final V value;

    public SimpleHolder(V value) {
        this.value = value;
    }
    
    @Override
    public V getValue() {
        return value;
    }
    
    
    
}
