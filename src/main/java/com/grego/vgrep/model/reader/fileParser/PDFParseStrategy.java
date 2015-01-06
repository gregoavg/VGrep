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
import org.slf4j.LoggerFactory;

/**
 * Parse strategy implementation for PDF documents.
 *
 * @author Grigorios
 *
 */
public final class PDFParseStrategy implements IDocumentParseStrategy {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PDFParseStrategy.class);

    @Override
    public Collection<String> parse(File file) {
        List<String> lines = new ArrayList<>();
        try {
            PdfReader reader = new PdfReader(file.getPath());
            for (int pageNum = 1; pageNum <= reader.getNumberOfPages(); pageNum++) {
                String page = PdfTextExtractor.getTextFromPage(reader, pageNum);
                lines.addAll(Arrays.asList(page.split("\n")));
            }
        } catch (IOException ex) {
            LOGGER.warn("Unable to read file!", ex.getLocalizedMessage());
        }
        return lines;
    }
}
