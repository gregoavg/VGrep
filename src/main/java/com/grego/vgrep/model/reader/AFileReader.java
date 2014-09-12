/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.File;
import java.util.Objects;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class AFileReader {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AFileReader.class);
    
    protected File file;

    public AFileReader(File file) {
        this.file = Objects.requireNonNull(file);
    }

    public AFileReader() {
        this.file = null;
    }

    public void setSource(File file) {
        this.file = Objects.requireNonNull(file);
    }

    public abstract <T> T read();
    
}
