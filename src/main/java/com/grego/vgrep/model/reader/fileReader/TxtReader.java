/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

import com.grego.vgrep.model.data.document.ContentBuilder;
import com.grego.vgrep.model.data.document.DocumentContents;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.model.reader.ADocumentReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Grigorios
 */
public final class TxtReader extends ADocumentReader {

    public TxtReader() {
        super();
    }
    
    @Override
    public DocumentContents read() throws IOException {
        ContentBuilder builder = new ContentBuilder();
        BufferedReader br = new BufferedReader(new FileReader(source));
        String lineText = br.readLine();
        while (lineText != null)
        {
            builder.appendLine(lineText);
            lineText = br.readLine();
        }
        return builder.getContents();
    }

}
