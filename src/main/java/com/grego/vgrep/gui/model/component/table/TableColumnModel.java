/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.component.table;

import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Grego
 */
public final class TableColumnModel {

    private final List<TableColumn> columns = new ArrayList<>();

    private final LineColumnProvider columnProvider = new LineColumnProvider(columns);

    public void scaleTo(Collection elements) {
        while (columns.size() < elements.size()) {
            TableColumn column = columnProvider.get();
            if (columns.add(column)) {
                column.setText(String.valueOf(columns.size()));
            }
        }
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void clear() {
        columns.clear();
    }

}
