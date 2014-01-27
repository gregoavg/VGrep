/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grigo_000
 */
public class XlsReader implements IReader {

    private File xlsFile;

    public XlsReader() {
    }

    public XlsReader(File xlsFile) {
        this.xlsFile = xlsFile;
    }

    @Override
    public File getFile() {
        return this.xlsFile;
    }

    @Override
    public void setFile(File file) {
        this.xlsFile = file;
    }

    @Override
    public String read() throws IOException {
       /* StringBuilder xlsContentBuilder = new StringBuilder();
        try
        {
            Workbook w = Workbook.getWorkbook(xlsFile);
            Sheet sheet = w.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++)
            {
                for (int j = 0; j < sheet.getColumns(); j++)
                {
                    Cell cellData = sheet.getCell(j, i);
                    xlsContentBuilder.append(cellData.getContents()).append(" ");
                }
                xlsContentBuilder.append("\n");
            }
        }
        catch (BiffException ex)
        {
            Logger.getLogger(XlsReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xlsContentBuilder.toString();*/
        return null;
    }
}
