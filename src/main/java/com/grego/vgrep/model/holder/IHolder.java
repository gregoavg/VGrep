/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.holder;

/**
 * Represents a holder of a particular value.
 * 
 * @author Grigorios
 * @param <V> type of the holed value
 * 
 */
public interface IHolder<V> {
    
    V getValue();

}
