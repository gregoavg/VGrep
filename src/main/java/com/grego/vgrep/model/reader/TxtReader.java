/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author grigo_000
 */
public class TxtReader implements IReader {

    private File txtfile;

    public TxtReader(File txtfile) {
        this.txtfile = txtfile;
    }

    public TxtReader() {
        this.txtfile = null;
    }

    @Override
    public File getFile() {
        return this.txtfile;
    }

    @Override
    public void setFile(File file) {
        this.txtfile = file;
    }

    @Override
    public String read() throws IOException {
        StringBuilder txtContentBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(this.txtfile));

        String line = br.readLine();
        while (line != null)
        {
            txtContentBuilder.append(line).append("\n");
            line = br.readLine();
        }
        return txtContentBuilder.toString();
    }

}
