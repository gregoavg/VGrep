/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.parseStrategy;

import java.io.File;
import java.util.Collection;

/**
 * Represents a parse strategy for files. It gathers the logic, that
 * is needed, in order to parse the content of a document.
 * 
 * @author Grigorios
 * 
 */
@FunctionalInterface
public interface IParseStrategy {
    
    /**
     * Returns the content of a document file, as a collection.
     * 
     * @param file
     * @return collection of strings
     * 
     */
    <T> Collection<T> parse(File file);

}
