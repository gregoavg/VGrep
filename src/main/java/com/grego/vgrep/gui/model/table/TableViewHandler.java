/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.table;

import com.grego.vgrep.event.ICallback;
import com.grego.vgrep.gui.control.loader.AsyncContentLoader;
import com.grego.vgrep.gui.control.loader.ILoader;
import com.grego.vgrep.gui.model.IComponentHandler;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IContent;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.model.holder.IHolder;
import com.grego.vgrep.model.holder.SimpleHolder;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of <code>IComponentHandler</code> specially for managing
 * JavaFX's <code>TableView</code> control object. It holds a field reference to
 * <code>TableView</code> component and manages it's dataset by adapting it to a
 * <code>TableColumnModel</code>. The dataset is populated by a provided data
 * file from application's model.
 *
 * @author Grego
 *
 */
public final class TableViewHandler implements IComponentHandler<TableView, ADataFile> {

    private final TableView table;
    private ADataFile dataModel;

    private final List<Line> dataSet = FXCollections.observableArrayList();
    private final TableColumnModel dataSetColumns = new TableColumnModel();

    private final ILoader<ADataFile, IContent> contentLoader = new AsyncContentLoader();

    public TableViewHandler(TableView table) {
        this.table = table;
        setupTable();
        setupLoader();
    }

    @Override
    public ADataFile getModel() {
        return dataModel;
    }

    @Override
    public void setModel(ADataFile dataFile) {
        if (!Objects.equals(this.dataModel, dataFile)) {
            this.dataModel = dataFile;
            tableDataChange();
        }
    }

    @Override
    public TableView getComponent() {
        return table;
    }

    private void setupTable() {
        table.setItems((ObservableList) dataSet);
        table.getColumns().setAll(dataSetColumns.getColumns());

        final TableViewSelectionModel columnSelectionModel = new ColumnSelectionModelAdapter(table);
        table.setSelectionModel(columnSelectionModel);

    }

    /**
     * Configures loader with a callback event that need to be executed after
     * the lazy initialization of file content.
     * 
     */
    private void setupLoader() {
        final ICallback<IContent> afterContentLoad = (content) -> {
            dataSet.addAll(content.list());
            dataSet.forEach((line) -> dataSetColumns.scaleTo(line.getColumns()));
            Platform.runLater(() -> table.getColumns().setAll(dataSetColumns.getColumns()));
        };
        contentLoader.setCallback(afterContentLoad);
    }

    private void tableDataChange() {
        dataSet.clear();
        dataSetColumns.clear();
        contentLoader.loadTo(dataModel);
    }

    @Override
    public List<IHolder<String>> getSelectedValues() {
        final List<IHolder<String>> selectedValues = new ArrayList<>();

        List<TablePosition> selectedCells = table.getSelectionModel().getSelectedCells();
        selectedCells.forEach((TablePosition position) -> {
            final IContent<String> content = dataModel.getContent();
            String selectedValue = content.getElementAt(position.getRow(), position.getColumn());
            if (!selectedValue.isEmpty()) {
                selectedValues.add(new SimpleHolder<>(selectedValue));
            }
        });
        return selectedValues;
    }

}
