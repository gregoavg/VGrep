/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.grego.vgrep.model.file.ADataFile;
import com.grego.vgrep.model.file.IContent;

/**
 * Represents a reader for data files. It is capable of traversing the file
 * and return it's contents by a single <code>read</code> method.
 * 
 * @author Grigorios
 * 
 */
public interface IReader {

    /**
     * Reads the provided file and returns it's contents.
     * 
     * @param dataFile the file to read.
     * @return contents of file.
     */
    IContent<?> read(final ADataFile dataFile);

}
