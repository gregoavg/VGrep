/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.gui.control.ListCellValueFactory;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.document.DocumentFile;
import com.grego.vgrep.model.data.document.Line;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewHandler implements IComponentHandler {

    private final TableView table;
    private DocumentFile dataModel;

    public TableViewHandler(TableView table) {
        this.table = table;
    }

    public TableViewHandler(TableView table, DocumentFile dataModel) {
        this.table = table;
        this.dataModel = dataModel;
        setupTable();
    }

    @Override
    public ADataFile getDataModel() {
        return dataModel;
    }

    @Override
    public void setDataModel(ADataFile dataModel) {
        if(dataModel instanceof DocumentFile)
        {
            this.dataModel = (DocumentFile) dataModel;
            setupTable();
        }
    }

    @Override
    public Object getComponent() {
        return table;
    }

    private void setupTable() {
        final List<TableColumn> tableColumns = new ArrayList<>();
        List<Line> dataSet = FXCollections.observableArrayList(dataModel.getContents().getLines());
        dataSet.parallelStream().forEach((Line line) ->
        {
            while(tableColumns.size() < line.getColumns().size())
            {
                TableColumn column = new TableColumn();
                if(tableColumns.add(column))
                {
                    column.setText(String.valueOf(tableColumns.size()));
                }
                column.setCellValueFactory(new ListCellValueFactory(tableColumns));
            }
        });
        table.getColumns().setAll(tableColumns);
        table.setItems((ObservableList) dataSet);
    }

}
