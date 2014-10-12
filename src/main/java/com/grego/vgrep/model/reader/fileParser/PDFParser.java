/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class PDFParser implements IDocumentParseStrategy {
    
    
    @Override
    public Collection<String> parse(File file) throws IOException {
        PdfReader reader = new PdfReader(file.getPath());
        
        List<String> lines = new ArrayList<>();
        for (int pageNum = 1; pageNum <= reader.getNumberOfPages(); pageNum++)
        {
            String page = PdfTextExtractor.getTextFromPage(reader, pageNum);
            lines.addAll(Arrays.asList(page.split("\n")));
        }
        return lines;
    }
}
