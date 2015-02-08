package com.grego.vgrep.model.reader.parseStrategy;

import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
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
    public Collection<String> parse(@NotNull File file) {
        Objects.requireNonNull(file, "file can not be null!!");
        LOGGER.info("Trying to read from " + file.getName());
        List<String> lines = new ArrayList<>();
        try {
             lines.addAll(Files.readAllLines(file.toPath()));
        } catch (Exception ex) {
            LOGGER.info("Trying to read file with buffer...");
            try (Stream<String> lineStream = new BufferedReader(new FileReader(file)).lines()) {
                lines.addAll(lineStream.collect(Collectors.toList()));
            } catch (IOException e) {
                LOGGER.warn("Unable to read file!", ex);
            }
        }
        return lines;
    }
}
