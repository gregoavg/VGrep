/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.IOException;
/**
 *
 * @author Grigorios
 * @param <S>
 * @param <R>
 */
public interface IReader<S,R> {
    
   R read(S source) throws IOException;
    
}
