/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.file.document;

import com.grego.viewmanager.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.grego.viewmanager.utils.ECompareResult.Equal;
import static com.grego.viewmanager.utils.ECompareResult.NotEqual;

/**
 * Core model data block that contains words in columnar mode. Also it is possible
 * to compare this with other instances of the same type, as it implements the
 * <code>Comparable</code> interface.
 * 
 * @author Grego
 * 
 */
public final class Line implements Comparable<Line> {

    private final static String SEPERATOR = " ";

    private final List<String> columns;

    public Line(String text) {
        String[] splitText = text.split(SEPERATOR);
        columns = new ArrayList<>(StringUtils.removeNodes(splitText, SEPERATOR));
    }

    /**
     * Returns all words of this line.
     * 
     * @return words as list of strings
     */
    public List<String> getColumns() {
        return columns;
    }
    
    /**
     * Returns an indexed word of this line, defined by it's index number.
     * 
     * @param index position of the word in line
     * @return word as string
     * 
     */
    public String getWordAt(int index) {
        try{
            return columns.get(index);
        }
        catch(IndexOutOfBoundsException ex) {
            return "";
        }
    }
    
    /**
     * Returns the number of words, indexed in this line.
     * 
     * @return number of words 
     */
    public int getWordCount() {
        return columns.size();
    }

    @Override
    public int compareTo(Line otherLine) {
        for(String word : columns) {
            for( String otherWord : otherLine.getColumns()) {
                if(otherWord.equals(word)) {
                    return Equal.getIntegerValue();
                }
            }
        }
        return NotEqual.getIntegerValue();
    }

    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder();
        columns.forEach((word) -> {
            strBuilder.append(word).append(" ");
        });
        return strBuilder.toString().trim();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.columns);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final String otherLineText = obj.toString();
        final String lineText = this.toString();

        return lineText.equals(otherLineText);
    }

}
