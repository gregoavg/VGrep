/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.parseStrategy;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Parse strategy implementation for XLS documents.
 *
 * @author Grigorios
 *
 */
public final class XlsParseStrategy implements IParseStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(XlsParseStrategy.class);

    @Override
    public Collection<String> parse(@NotNull File file) {
        Objects.requireNonNull(file, "file can not be null!!");
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
