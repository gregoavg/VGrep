/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.parseStrategy;

/**
 * Static Factory pattern implementation, in order to provide clients with
 * the appropriate document parse strategy.
 * 
 * @author Grigorios
 * 
 */
public final class DocumentParseStrategyFactory {

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
    public static IParseStrategy getStrategy(EFileType type) {
        switch (type)
        {
            case PDF:
                return new PdfParseStrategy();
            case XLS:
                return new XlsParseStrategy();
            case TXT:
                return new SimpleParseStrategy();
            default:
                return new SimpleParseStrategy();
        }
    }
    
}
