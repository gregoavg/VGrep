/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import com.grego.vgrep.model.data.document.DocumentContents;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public interface IDocumentParseStrategy {
    
    DocumentContents parse(File file) throws IOException;

}
