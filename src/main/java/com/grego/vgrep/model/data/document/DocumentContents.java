/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grego.vgrep.model.data.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Grego
 */
public final class DocumentContents implements Iterable<Line> {
    
    private final List<Line> lines;

    public DocumentContents(List<Line> lines) {
        this.lines = lines;
    }

    public DocumentContents() {
        lines = new ArrayList<>();
        lines.add(new Line("Empty document file!!!!"));
    }
    
    public List<Line> getLines() {
        return lines;
    }
    
    public int getNumberOfLines() {
        return lines.size();
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.listIterator();
    }
}
