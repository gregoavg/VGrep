/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Represents a parse strategy for document files. It gathers the logic, that
 * is needed, in order to parse the content of a document.
 * 
 * @author Grigorios
 * 
 */
@FunctionalInterface
public interface IDocumentParseStrategy {
    
    /**
     * Returns the content of a document file, as a collection.
     * 
     * @param file
     * @return collection of strings
     * 
     */
    Collection<String> parse(File file);

}
