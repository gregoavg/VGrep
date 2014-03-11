/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.control;

import com.grego.vgrep.model.reader.IReader;
import com.grego.vgrep.model.reader.PDFReader;
import com.grego.vgrep.model.reader.TxtReader;
import com.grego.vgrep.model.reader.XlsReader;

/**
 *
 * @author grigo_000
 */
public class ReaderFactory {
    
    public static IReader getInstance(EFileType type)
    {
        switch( type )
        {
            case PDF:
                return new PDFReader();
            case XLS:
                return new XlsReader();
            case TXT:
                return new TxtReader();
            default:
                return null;
        }
    }
    
}
