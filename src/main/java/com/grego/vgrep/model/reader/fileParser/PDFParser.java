/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import com.grego.vgrep.model.data.document.ContentBuilder;
import com.grego.vgrep.model.data.document.DocumentContents;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public final class PDFParser implements IDocumentParseStrategy {
    
    
    @Override
    public DocumentContents parse(File file) throws IOException {
        PdfReader reader = new PdfReader(file.getPath());
        int numOfPages = reader.getNumberOfPages();
        
        ContentBuilder builder = new ContentBuilder();
        for (int pageNum = 1; pageNum <= numOfPages; pageNum++)
        {
            String page = PdfTextExtractor.getTextFromPage(reader, pageNum);
            for(String lineText : page.split("\n"))
            {
                builder.appendLine(lineText);
            }
        }
        return builder.getContents();
    }
}
