/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public interface IDocumentParseStrategy {
    
    <T> T parse(File file) throws IOException;

}
