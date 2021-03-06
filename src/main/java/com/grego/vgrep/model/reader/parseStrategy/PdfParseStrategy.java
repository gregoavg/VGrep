package com.grego.vgrep.model.reader.parseStrategy;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Parse strategy implementation for PDF documents.
 *
 * @author Grigorios
 *
 */
public final class PdfParseStrategy implements IParseStrategy {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PdfParseStrategy.class);

    @Override
    public Collection<String> parse(@NotNull File file) {
        Objects.requireNonNull(file, "file can not be null!!");
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
