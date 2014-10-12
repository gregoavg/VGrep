/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.gui.control.ListCellValueFactory;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.document.DocumentContent;
import com.grego.vgrep.model.data.document.IFileContent;
import com.grego.vgrep.model.data.document.Line;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.util.Callback;

public final class TableViewHandler implements IComponentHandler {

    private final TableView table;
    private ADataFile dataModel;

    private final List<TableColumn> tableColumns = new ArrayList<>();
    private final ObservableList<Line> dataSet = FXCollections.observableArrayList();

    public TableViewHandler(TableView table) {
        this.table = table;
        setupTable();
    }

    public TableViewHandler(TableView table, ADataFile dataModel) {
        this.table = table;
        this.dataModel = dataModel;
        setupTable();
        tableDataChange();
    }

    @Override
    public ADataFile getDataModel() {
        return dataModel;
    }

    @Override
    public void setDataModel(ADataFile dataModel) {
        this.dataModel = dataModel;
        tableDataChange();
    }

    @Override
    public Object getComponent() {
        return table;
    }

    private void setupTable() {
        table.setItems(dataSet);
        TableViewSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setCellSelectionEnabled(true);
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
    }

    @SuppressWarnings("unchecked")
    private void tableDataChange() {
        tableColumns.clear();
        Callback listCellValueFactory = new ListCellValueFactory(tableColumns);

        IFileContent content = dataModel.getReader().read();
        if(content instanceof DocumentContent)
        {
            dataSet.setAll(((DocumentContent) content).getLines());
        }
        dataSet.parallelStream().forEach((line) -> {
            while (tableColumns.size() < line.getColumns().size()) {
                TableColumn column = new TableColumn();
                if (tableColumns.add(column)) {
                    column.setText(String.valueOf(tableColumns.size()));
                }
                column.setCellValueFactory(listCellValueFactory);
            }
        });
        table.getColumns().setAll(tableColumns);
    }

}
