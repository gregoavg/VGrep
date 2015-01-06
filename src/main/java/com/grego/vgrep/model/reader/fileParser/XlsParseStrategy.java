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
 * Parse strategy implementation for XLS documents.
 *
 * @author Grigorios
 *
 */
public final class XlsParseStrategy implements IDocumentParseStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsParseStrategy.class);

    @Override
    public Collection<String> parse(File file) {
        List<String> lines = new ArrayList<>();
        try {
            Workbook w = Workbook.getWorkbook(file);
            for (Sheet sheet : w.getSheets()) {
                for (int rowIndex = 0; rowIndex < sheet.getRows(); rowIndex++) {
                    StringBuilder lineBuilder = new StringBuilder();
                    for (int colInd = 0; colInd < sheet.getColumns(); colInd++) {
                        String cellContent = sheet.getCell(colInd, rowIndex).getContents();
                        lineBuilder.append(cellContent.trim()).append(" ");
                    }
                    lines.add(lineBuilder.toString());
                }
            }
        } catch (BiffException | IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return lines;
    }
}
