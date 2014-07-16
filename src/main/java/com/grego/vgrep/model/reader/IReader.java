/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public interface IReader {
    
    void setSource(Object source);
    
    <T> T read() throws IOException;

}
