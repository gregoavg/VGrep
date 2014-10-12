/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author grrowIndgo_000
 */
public final class XlsParser implements IDocumentParseStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsParser.class);

    @Override
    public Collection<String> parse(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            Workbook w = Workbook.getWorkbook(file);
            Sheet sheet = w.getSheet(0);
            for (int rowInd = 0; rowInd < sheet.getRows(); rowInd++)
            {
                StringBuilder lineBuilder = new StringBuilder();
                for (int colInd = 0; colInd < sheet.getColumns(); colInd++)
                {
                    String cellContent = sheet.getCell(colInd, rowInd).getContents();
                    lineBuilder.append(cellContent.trim()).append(" ");
                }
                lines.add(lineBuilder.toString());
            }
        }
        catch (BiffException ex) {
            LOGGER.error(ex.getMessage());
        }
        return lines;
    }
}
