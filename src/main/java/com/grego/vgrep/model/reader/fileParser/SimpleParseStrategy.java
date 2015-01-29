package com.grego.vgrep.model.reader.fileParser;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Parse strategy implementation for unsupported documents. This implementation
 * makes use of the new <code>Java 8 API</code> for reading files.
 *
 * @author Grigorios
 *
 */
public class SimpleParseStrategy implements IParseStrategy {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SimpleParseStrategy.class);

    @Override
    public Collection<String> parse(File file) {
        LOGGER.info("Trying to read from " + file.getName());
        try {
             return Files.readAllLines(file.toPath());
        } catch (IOException ex) {
            LOGGER.info("Trying to read file with buffer...");
            try (Stream<String> lines = new BufferedReader(new FileReader(file)).lines()) {
                return lines.collect(Collectors.toList());
            } catch (IOException e) {
                LOGGER.warn("Unable to read file!", ex);
            }
        }
        return Collections.emptyList();
    }
}
