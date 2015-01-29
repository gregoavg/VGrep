/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.table;

import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.List;

/**
 *
 * @author Grego
 */
public final class LineColumnBuilder {
    
    private final Callback lineCellValueFactory;
    
    public LineColumnBuilder(List<TableColumn> tableColumns) {
        lineCellValueFactory = new LineCellValueFactory(tableColumns);
    }
    
    public TableColumn create() {
        final TableColumn column = new TableColumn();
        column.setCellValueFactory(lineCellValueFactory);
        return column;
    }
    
}
