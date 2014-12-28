package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

/**
 * Created by grigoris on 28/12/2014.
 */
public class SimpleFileParser implements IDocumentParseStrategy {

    @Override
    public Collection<String> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
