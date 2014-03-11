/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.utils.TableUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author grigo_000
 */
public final class PreviewTableModel extends AbstractTableModel {

    private List<String> contentLines;

    public PreviewTableModel(List<String> data) {
        this.contentLines = data;
    }

    public List<String> getData() {
        return contentLines;
    }

    public void setData(List<String> data) {
        this.contentLines = data;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.contentLines.size();
    }

    @Override
    public int getColumnCount() {
        return TableUtils.getMaxColSize(contentLines);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rowValue = contentLines.get(rowIndex).split(" ");
        if (columnIndex > rowValue.length - 1)
        {
            return "";
        }
        else
        {
            return rowValue[columnIndex];
        }
    }

    public Collection<String> getDataFromColumns(int[] selectedColumns) {
        Collection<String> selectedData = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.getRowCount(); rowIndex++)
        {
            StringBuilder rowDataBuilder = new StringBuilder();
            for (int selectedColIndex : selectedColumns)
            {
                rowDataBuilder.append(getValueAt(rowIndex, selectedColIndex)).append(" ");
            }
            selectedData.add(rowDataBuilder.toString());
        }
        return selectedData;
    }

}
