package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import org.slf4j.LoggerFactory;

/**
 * Parse strategy implementation for unsupported documents. This implementation
 * makes use of the new <code>Java 8 API</code> for reading files.
 *
 * @author Grigorios
 *
 */
public class SimpleParseStrategy implements IDocumentParseStrategy {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SimpleParseStrategy.class);

    @Override
    public Collection<String> parse(File file) {
        try {
            return file != null ?
                    Files.readAllLines(file.toPath()) : Collections.emptyList();
        } catch (IOException ex) {
            LOGGER.warn("Unable to read file!", ex.getLocalizedMessage());
            return Collections.emptyList();
        }
    }
}
