/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author grigo_000
 */
public class PDFReader implements IReader {

    private File pdfFile;

    public PDFReader() {
        this.pdfFile = null;
    }

    public PDFReader(File pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public void setFile(File file) {
        this.pdfFile = file;
    }

    @Override
    public String read() throws IOException {
        PdfReader reader = new PdfReader(pdfFile.getPath());
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
