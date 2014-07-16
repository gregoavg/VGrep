/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

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
    public String read() throws IOException {
        StringBuilder txtContentBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(source));
        String line = br.readLine();
        while (line != null)
        {
            txtContentBuilder.append(line).append("\n");
            line = br.readLine();
        }
        return txtContentBuilder.toString();
    }

}
