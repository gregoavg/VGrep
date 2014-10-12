/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data.document;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grego
 */
public final class DocumentContent implements IFileContent {

    private final List<Line> lines;

    public DocumentContent() {
        lines = new ArrayList<>();
        lines.add(new Line("No document file inserted"));
    }
    
    //called from content builder
    private DocumentContent(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getNumberOfLines() {
        return lines.size();
    }

    @Override
    public List<String> listContent() {
        final List<String> contentList = new ArrayList<>();
        lines.forEach((Line line) -> {
            contentList.add(line.toString());
        });

        return contentList;
    }
    
    
    public final static class ContentBuilder {

        private final List<Line> indexLines = new ArrayList<>();

        public ContentBuilder appendLine(String text) {
            indexLines.add(new Line(text));
            return this;
        }
        
        public DocumentContent createContents() {
            return new DocumentContent(indexLines);
        }
    }
}
