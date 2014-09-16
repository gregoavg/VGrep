/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.document.DocumentFile;
import com.grego.vgrep.model.data.document.Line;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author Grigorios
 */
public class TableViewManager {

    private final TableView table;
    private DocumentFile document;

    private final List<TableColumn> tableColumns = new ArrayList<>();

    public TableViewManager(TableView table) {
        this.table = table;
    }

    public void setDataFile(ADataFile data) {
        if (data instanceof DocumentFile)
        {
            this.document = (DocumentFile) data;
            setupGrid();
        }
    }

    private void setupGrid() {
        for (Line line : document.getContents().getLines())
        {
            for (String column : line.getColumns())
            {
                if (tableColumns.size() == line.getColumns().indexOf(column))
                {
                    TableColumn tableCol = new TableColumn("");
                    tableColumns.add(tableCol);
                    tableCol.setCellValueFactory(new Callback<CellDataFeatures<Line, String>, ObservableValue<String>>() {
                        @Override
                        public ObservableValue<String> call(CellDataFeatures<Line, String> rowData) {
                            Line rowDataValue = rowData.getValue();
                            String cellValue;
                            try
                            {
                                int colIndex = tableColumns.indexOf(rowData.getTableColumn());
                                cellValue = rowDataValue.getColumns().get(colIndex);
                            }
                            catch (IndexOutOfBoundsException ex)
                            {
                                cellValue = "";
                            }
                            return new SimpleStringProperty(cellValue);
                        }
                    });
                }
            }
        }
        table.getColumns().setAll(tableColumns);
        ObservableList<Line> dataSet = FXCollections.observableArrayList(document.getContents().getLines());
        table.setItems(dataSet);
    }
}
