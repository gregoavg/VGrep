/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.model;

import com.grego.vgrep.model.IReference;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Grigorios
 */
public final class ReferenceTableModel extends AbstractTableModel {

    private List<IReference> referenceList;

    public ReferenceTableModel() {
        this.referenceList = new ArrayList<>();
    }

    public ReferenceTableModel(List<IReference> referenceList) {
        this.referenceList = referenceList;
    }

    public List<IReference> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<IReference> referenceArList) {
        this.referenceList = referenceArList;
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return referenceList.size();
    }

    @Override
    public String getColumnName(int column) {
        String value = "";
        switch (column)
        {
            case 0:
                value = "Given Info";
                break;
            case 1:
                value = "Referenced Data";
        }
        return value;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IReference ref = referenceList.get(rowIndex);
        return columnIndex == 0 ? ref.getReferencedLine() : "";
    }
}
