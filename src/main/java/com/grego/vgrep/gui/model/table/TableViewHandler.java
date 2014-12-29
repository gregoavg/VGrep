/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.table;

import com.grego.vgrep.gui.model.IComponentHandler;
import com.grego.vgrep.model.holder.IHolder;
import com.grego.vgrep.model.holder.SimpleValueHolder;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;
import com.grego.vgrep.model.data.document.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

public final class TableViewHandler implements IComponentHandler {

    private final TableView table;
    private ADataFile dataModel;
    
    private final List<Line> dataSet = FXCollections.observableArrayList();    
    private final TableColumnModel dataSetColumns = new TableColumnModel();

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
        table.getColumns().setAll(dataSetColumns.getColumns());
        
        final TableViewSelectionModel columnSelectionModel = new ColumnSelectionModelAdapter(table);
        table.setSelectionModel(columnSelectionModel);

    }

    @SuppressWarnings("unchecked")
    private void tableDataChange() {
        dataSetColumns.clear();
        dataSet.clear();
        
        Runnable loadFile = () -> {
            final IFileContent content = dataModel.getContent();          
            dataSet.addAll(content.list());
            
            dataSet.forEach((Line line) -> {
               dataSetColumns.scaleTo(line.getColumns());
            });
            Platform.runLater(() -> {
                table.getColumns().setAll(dataSetColumns.getColumns());
            });
        };
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(loadFile);
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
        return selectedValues;
    }

}
