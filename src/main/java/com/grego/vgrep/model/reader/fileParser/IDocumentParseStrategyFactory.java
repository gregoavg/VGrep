/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.util.Collections;

/**
 * Static Factory pattern implementation, in order to provide clients with
 * the appropriate document parse strategy.
 * 
 * @author Grigorios
 * 
 */
public final class IDocumentParseStrategyFactory {

    /**
     * Returns a document parse strategy instance, based on 
     * the provided document file type.
     * 
     * @param  type document file type
     * @return parse strategy if the file type is supported or
     *         simple parse strategy for unsupported documents.
     *         Also, on unexpected conditions, a default parse strategy is returned,
     *         that provides an empty collection.    
     * @see    EFileType
     * 
     */
    public static IDocumentParseStrategy getInstance(EFileType type) {
        switch (type)
        {
            case PDF:
                return new PDFParseStrategy();
            case XLS:
                return new XlsParseStrategy();
            case TXT:
                return new SimpleParseStrategy();
            case OTHER:
                return new SimpleParseStrategy();
            default:
                return (file) -> {
                    return Collections.emptyList();
                };
        }
    }
    
}
