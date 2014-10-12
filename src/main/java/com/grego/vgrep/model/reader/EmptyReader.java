/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.grego.vgrep.model.data.document.IFileContent;
import java.util.Collections;

/**
 *
 * @author Grigorios
 */
public class EmptyReader extends AFileReader {

    @Override
    public IFileContent read() {
        return () -> Collections.emptyList();
    }
    
}
