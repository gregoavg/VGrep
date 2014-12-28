/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.gui.control.ListCellValueFactory;
import com.grego.vgrep.model.holder.IHolder;
import com.grego.vgrep.model.holder.SimpleValueHolder;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;
import com.grego.vgrep.model.data.document.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.util.Callback;

public final class TableViewHandler implements IComponentHandler {

    private final TableView table;
    private ADataFile dataModel;

    private final List<TableColumn> tableColumns = new ArrayList<>();
    private final List<Line> dataSet = FXCollections.observableArrayList();

    public TableViewHandler(TableView table) {
        this.table = table;
        setupTable();
    }

    public TableViewHandler(TableView table, ADataFile file) {
        this.table = table;
        this.dataModel = file;
        setupTable();
        tableDataChange();
    }

    @Override
    public ADataFile getDataModel() {
        return dataModel;
    }

    @Override
    public void setDataModel(ADataFile dataFile) {
        if (!Objects.equals(this.dataModel, dataFile)) {
            this.dataModel = dataFile;
            tableDataChange();
        }
    }

    @Override
    public Object getComponent() {
        return table;
    }

    private void setupTable() {
        table.setItems((ObservableList) dataSet);
        final TableViewSelectionModel columnSelectionModel = new ColumnSelectionModelAdapter(table);
        table.setSelectionModel(columnSelectionModel);

    }

    @SuppressWarnings("unchecked")
    private void tableDataChange() {
        tableColumns.clear();
        Callback listCellValueFactory = new ListCellValueFactory(tableColumns);

        IFileContent content = dataModel.getContent();
        dataSet.clear();
        dataSet.addAll(content.list());

        dataSet.parallelStream().forEach((line) -> {
            while (tableColumns.size() < line.getWordCount()) {
                TableColumn column = new TableColumn();
                if (tableColumns.add(column)) {
                    column.setText(String.valueOf(tableColumns.size()));
                }
                column.setCellValueFactory(listCellValueFactory);
            }
        });
        table.getColumns().setAll(tableColumns);
    }

    @Override
    public List<IHolder> getSelectedValues() {
        List<TablePosition> selectedCells = table.getSelectionModel().getSelectedCells();
        final List<IHolder> selectedValues = new ArrayList<>();
        
        selectedCells.forEach((TablePosition position) -> {
            final IFileContent<String> content = dataModel.getContent();
            String selectedValue = content.getElementAt(position.getRow(), position.getColumn());
            
            if (!selectedValue.isEmpty()) {
                selectedValues.add(new SimpleValueHolder(selectedValue));
            }
        });
    return selectedValues ;
}

}
