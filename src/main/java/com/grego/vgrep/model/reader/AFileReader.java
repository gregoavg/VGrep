/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;
import java.util.Collections;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class AFileReader {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AFileReader.class);
    
    protected ADataFile dataFile;
    
    public void setSource(ADataFile file) {
        this.dataFile = file;
    }

    public abstract IFileContent read();
    
    
    
    /**
     * helper class to handle empty sourceFile reader
     */
    public static final class EmptyReader extends AFileReader {

        @Override
        public IFileContent read() {
            return new IFileContent() {
                @Override
                public List<Comparable> list() {
                    return Collections.emptyList();
                }

                @Override
                public Object getElementAt(int lineIndex, int rowIndex) {
                    return new Object();
                }
            };
        }
    }
    
}
