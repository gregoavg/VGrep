/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

import com.grego.vgrep.model.reader.IReader;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Grigorios
 */
public final class PDFReader implements IReader<File, String> {

    @Override
    public String read(File source) throws IOException {
        PdfReader reader = new PdfReader(source.getPath());
        int numOfPages = reader.getNumberOfPages();
        
        StringBuilder pdfContentBuilder = new StringBuilder();
        for (int pageNum = 1; pageNum <= numOfPages; pageNum++)
        {
            String page = PdfTextExtractor.getTextFromPage(reader, pageNum);
            pdfContentBuilder.append(page).append("\n");
        }
        return pdfContentBuilder.toString();
    }
}
