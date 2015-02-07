/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file.document;

import com.grego.vgrep.model.file.IContent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of {@link com.grego.vgrep.model.file.IContent} for modeling
 * document file content, that consists of lines that contain words in the form of columns.
 * 
 * @author Grigorios
 */
public final class DocumentContent implements IContent<Line> {

    private final List<Line> lines;

    public DocumentContent() {
        this.lines = new ArrayList<>();
        lines.add(new Line("No document file inserted"));
    }
    
    //called from content builder
    private DocumentContent(Collection<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }
    
    public int getNumberOfLines() {
        return lines.size();
    }

    /**
     * Returns an independent and ready for manipulation, list of content lines.
     * When the content is provided by this method, clients can freely manipulate
     * the list, as opposed, by their interest.
     *
     * @return a list of lines
     */
    @Override
    public List<Line> list() {
        return new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return lines;
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
    
    /**
     * Helper class that makes use of Builder pattern in order to effectively
     * collect and finally construct a document's content.
     * 
     */
    public final static class ContentBuilder {

        private final List<Line> indexLines = new ArrayList<>();

        /**
         * Append a line to this builder
         * 
         * @param text all words of one document line.
         * @return the builder itself. 
         * 
         */
        public ContentBuilder appendLine(String text) {
            indexLines.add(new Line(text));
            return ContentBuilder.this;
        }
        
        /**
         * Creates and returns an instance of <code>DocumentContent</code>
         * by invoking it's private constructor with the collection of appended lines.
         * 
         * @return
         * @see DocumentContent
         */
        public DocumentContent createContents() {
            return new DocumentContent(indexLines);
        }
    }
}
