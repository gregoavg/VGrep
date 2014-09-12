/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import com.grego.vgrep.model.reader.fileParser.EFileType;
import com.grego.vgrep.model.reader.fileParser.PDFParser;
import com.grego.vgrep.model.reader.fileParser.TxtParser;
import com.grego.vgrep.model.reader.fileParser.XlsParser;

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
            default:
                return null;
        }
    }

}
