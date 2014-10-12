/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Grigorios
 */
public interface IDocumentParseStrategy {
    
    Collection<String> parse(File file) throws IOException;

}
