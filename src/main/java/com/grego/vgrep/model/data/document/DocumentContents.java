/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grego.vgrep.model.data.document;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Grego
 */
public class DocumentContents {
    
    private final List<Line> lines;

    public DocumentContents(List<Line> lines) {
        this.lines = lines;
    }
    
    public List<Line> getLines() {
        return lines;
    }
    
    public ListIterator<Line> getIterator() {
        return lines.listIterator();
    }
    
    public int getNumberOfLines() {
        return lines.size();
    }
}
