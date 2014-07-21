/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

import com.grego.vgrep.model.data.document.ContentBuilder;
import com.grego.vgrep.model.data.document.DocumentContents;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.model.reader.ADocumentReader;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public final class PDFReader extends ADocumentReader {

    public PDFReader() {
        super();
    }

    @Override
    public DocumentContents read() throws IOException {
        PdfReader reader = new PdfReader(source.getPath());
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
