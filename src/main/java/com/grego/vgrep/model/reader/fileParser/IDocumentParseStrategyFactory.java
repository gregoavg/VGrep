/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.util.Collections;

/**
 *
 * @author grigo_000
 */
public final class IDocumentParseStrategyFactory {

    public static IDocumentParseStrategy getInstance(EFileType type) {
        switch (type)
        {
            case PDF:
                return new PDFParser();
            case XLS:
                return new XlsParser();
            case TXT:
                return new TxtParser();
            case OTHER:
                return new SimpleFileParser();
            default:
                return () -> {
                    return Collections.emptyList();
                }
        }
        
}
