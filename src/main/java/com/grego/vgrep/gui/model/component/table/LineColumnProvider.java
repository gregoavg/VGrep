/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.component.table;

import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.List;

/**
 *
 * @author Grego
 */
public final class LineColumnProvider {
    
    private final Callback lineCellValueFactory;
    
    public LineColumnProvider(List<TableColumn> tableColumns) {
        lineCellValueFactory = new LineCellValueFactory(tableColumns);
    }
    
    public TableColumn get() {
        final TableColumn column = new TableColumn();
        column.setCellValueFactory(lineCellValueFactory);
        return column;
    }
    
}
