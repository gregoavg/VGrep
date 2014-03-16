/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

import com.grego.vgrep.model.reader.fileReader.AFileReader;
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
public class XlsReader extends AFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsReader.class);

    @Override
    public String read() throws IOException {
       StringBuilder xlsContentBuilder = new StringBuilder();
        try
        {
            Workbook w = Workbook.getWorkbook(file);
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
