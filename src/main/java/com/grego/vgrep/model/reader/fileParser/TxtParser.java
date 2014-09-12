/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import com.grego.vgrep.model.data.document.ContentBuilder;
import com.grego.vgrep.model.data.document.DocumentContents;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Grigorios
 */
public final class TxtParser implements IDocumentParseStrategy {
    
    @Override
    public DocumentContents parse(File file) throws IOException {
        ContentBuilder builder = new ContentBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String lineText = br.readLine();
        while (lineText != null)
        {
            builder.appendLine(lineText);
            lineText = br.readLine();
        }
        return builder.getContents();
    }

}
