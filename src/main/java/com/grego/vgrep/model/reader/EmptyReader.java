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

/**
 * Helper class to handle empty sourceFile reader. This helper is part of the
 * application's null object pattern implementation and it's main use is to
 * eliminate conditional statements about reader capability to read a data file.
 * 
 * @author Grego
 * 
 */
public final class EmptyReader implements IFileReader {

    @Override
    public IFileContent read(final ADataFile dataFile) {
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
