/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class TxtParser implements IDocumentParseStrategy {

    @Override
    public Collection<String> parse(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            List<String> lines = new ArrayList<>();
            String lineText = br.readLine();
            while(lineText != null) {
                lines.add(lineText);
                lineText = br.readLine();
            }
            return lines;
        }
    }
}
