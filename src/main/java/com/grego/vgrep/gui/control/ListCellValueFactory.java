/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control;

import com.grego.vgrep.model.data.document.Line;
import java.util.List;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author Grigorios
 */
public class ListCellValueFactory implements Callback<TableColumn.CellDataFeatures<Line, String>, ObservableValue<String>> {

    private final List<TableColumn> columns;

    public ListCellValueFactory(List<TableColumn> columns) {
        this.columns = columns;
    }
    
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Line, String> param) {
        Line rowDataValue = param.getValue();
        String cellValue;
        int colIndex = columns.indexOf(param.getTableColumn());
        cellValue = rowDataValue.getWordAt(colIndex);
        if(Objects.isNull(cellValue)) {
            cellValue = "";
        }
        return new SimpleStringProperty(cellValue);
    }

}
