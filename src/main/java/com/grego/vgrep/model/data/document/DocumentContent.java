/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data.document;

import com.grego.vgrep.model.data.IFileContent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grego
 */
public final class DocumentContent implements IFileContent<String> {

    private final List<Line> lines = new ArrayList<>();

    public DocumentContent() {
        lines.add(new Line("No document file inserted"));
    }
    
    //called from content builder
    private DocumentContent(List<Line> lines) {
        this.lines.addAll(lines);
    }
    
    public int getNumberOfLines() {
        return lines.size();
    }

    @Override
    public List<Comparable> list() {
        return new ArrayList<>(lines);
    }
    
    @Override
    public String getElementAt(int lineIndex, int columnIndex) {
        try {
            Line line = lines.get(lineIndex);
            return line.getWordAt(columnIndex);
        }
        catch(IndexOutOfBoundsException ex) {
            return "";
        }
    }
    
    public final static class ContentBuilder {

        private final List<Line> indexLines = new ArrayList<>();

        public ContentBuilder appendLine(String text) {
            indexLines.add(new Line(text));
            return ContentBuilder.this;
        }
        
        public DocumentContent createContents() {
            return new DocumentContent(indexLines);
        }
    }
}
