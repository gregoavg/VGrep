/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.holder;

/**
 *
 * @author Grigorios
 * @param <V> Value type
 */
public final class SimpleValueHolder<V> implements IHolder<V> {

    private final V value;

    public SimpleValueHolder(V value) {
        this.value = value;
    }
    
    @Override
    public V getValue() {
        return value;
    }
    
}
