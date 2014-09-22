/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.grego.vgrep.model.data.ADataFile;
import java.io.File;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class AFileReader {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AFileReader.class);
    
    protected ADataFile dataFile = null;
    
    public void setSource(ADataFile file) {
        this.dataFile = file;
    }

    public abstract <T> T read();
    
}
