/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileReader;

import com.grego.vgrep.model.data.document.ContentBuilder;
import com.grego.vgrep.model.data.document.DocumentContents;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.model.reader.ADocumentReader;
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
public final class XlsReader extends ADocumentReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsReader.class);

    public XlsReader() {
        super();
    }

    @Override
    public DocumentContents read() throws IOException {
        ContentBuilder builder = new ContentBuilder();
        try
        {
            Workbook w = Workbook.getWorkbook(source);
            Sheet sheet = w.getSheet(0);
            for (int rowInd = 0; rowInd < sheet.getRows(); rowInd++)
            {
                StringBuilder lineBuilder = new StringBuilder();
                for (int colInd = 0; colInd < sheet.getColumns(); colInd++)
                {
                    Cell cell = sheet.getCell(colInd, rowInd);
                    lineBuilder.append(cell.getContents()).append(" ");
                }
                builder.appendLine(lineBuilder.toString());
            }
        }
        catch (BiffException ex)
        {
            LOGGER.error(ex.getMessage());          
        }
        return builder.getContents();
    }
}
