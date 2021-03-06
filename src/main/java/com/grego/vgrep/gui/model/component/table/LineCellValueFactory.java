/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.component.table;

import com.grego.vgrep.model.file.document.Line;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class LineCellValueFactory implements Callback<TableColumn.CellDataFeatures<Line, String>, ObservableValue<String>> {

    private final List<TableColumn> columns;

    public LineCellValueFactory(List<TableColumn> columns) {
        this.columns = columns;
    }
    
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Line, String> param) {
        Line rowDataValue = param.getValue();
        int colIndex = columns.indexOf(param.getTableColumn());
        String cellValue = rowDataValue.getWordAt(colIndex);
        return new SimpleStringProperty(cellValue);
    }

}
