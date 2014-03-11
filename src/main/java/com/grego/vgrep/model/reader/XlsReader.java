/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author grrowIndgo_000
 */
public class XlsReader implements IReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsReader.class);
    private File xlsFile;

    public XlsReader() {
    }

    public XlsReader(File xlsFile) {
        this.xlsFile = xlsFile;
    }
    
    @Override
    public void setFile(File file) {
        this.xlsFile = file;
    }

    @Override
    public String read() throws IOException {
       StringBuilder xlsContentBuilder = new StringBuilder();
        try
        {
            Workbook w = Workbook.getWorkbook(xlsFile);
            Sheet sheet = w.getSheet(0);
            for (int rowInd = 0; rowInd < sheet.getRows(); rowInd++)
            {
                for (int colInd = 0; colInd < sheet.getColumns(); colInd++)
                {
                    Cell cell = sheet.getCell(colInd, rowInd);
                    xlsContentBuilder.append(cell.getContents()).append(" ");
                }
                xlsContentBuilder.append("\n");
            }
        }
        catch (BiffException ex)
        {
            LOGGER.error(ex.getMessage());          
        }
        return xlsContentBuilder.toString();
    }
}
