/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

/**
 *
 * @author Grigorios
 * @param <S> source of reference 
 * @param <T> target of reference
 */
public interface IReference<S,T> {

    S getSource();

    T getTarget();

    @Override
    String toString();
    
}
