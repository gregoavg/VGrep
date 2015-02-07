/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model.component.table;

import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class ColumnSelectionModelAdapter extends TableViewSelectionModel {
    
    private final TableViewSelectionModel selectionModelAdaptee;
    
//section: selection properties

    private final SelectionMode multySelection = SelectionMode.MULTIPLE;
    private final boolean enableCellSelection = true;

//end: selection properties
    
    public ColumnSelectionModelAdapter(final TableView tableView) {
        super(tableView);
        this.setCellSelectionEnabled(enableCellSelection);
        this.setSelectionMode(multySelection);
        
        selectionModelAdaptee = tableView.getSelectionModel();
        syncAdapteeToAdapter();
    }
    
    private void syncAdapteeToAdapter() {
        selectionModelAdaptee.setCellSelectionEnabled(enableCellSelection);
        selectionModelAdaptee.setSelectionMode(multySelection);  
    }

    @Override
    public ObservableList getSelectedCells() {
        return selectionModelAdaptee.getSelectedCells();
    }

    @Override
    public boolean isSelected(int row, TableColumn column) {
        return selectionModelAdaptee.isSelected(row, column);
    }

    @Override
    public void select(int row, TableColumn column) {
        selectColumn(column);
    }

    @Override
    public void clearAndSelect(int row, TableColumn column) {
        selectionModelAdaptee.clearSelection();
        selectColumn(column);
    }

    @Override
    public void clearSelection(int row, TableColumn column) {
        selectionModelAdaptee.clearSelection();
    }

    @Override
    public void selectLeftCell() {
        selectionModelAdaptee.selectLeftCell();
    }

    @Override
    public void selectRightCell() {
        selectionModelAdaptee.selectLeftCell();
    }

    @Override
    public void selectAboveCell() {
        selectionModelAdaptee.selectAboveCell();
    }

    @Override
    public void selectBelowCell() {
        selectionModelAdaptee.selectAboveCell();
    }
    
    private void selectColumn(TableColumn column) {
        final List<Object> items = selectionModelAdaptee.getTableView().getItems();
        int lastItemIndex = items.size() - 1;
        selectionModelAdaptee.selectRange(0, column, lastItemIndex, column);
    }
    
}
