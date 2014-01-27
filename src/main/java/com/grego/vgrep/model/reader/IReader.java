/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author grigo_000
 */
public interface IReader {

    File getFile();

    void setFile(File file);
    
    String read() throws IOException;
    
}
