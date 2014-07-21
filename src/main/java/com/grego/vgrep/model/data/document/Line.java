/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grego.vgrep.model.data.document;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Grego
 */
public class Line {
    
    private final List<String> columns;

    public Line(String text) {
        columns = Arrays.asList(text.split(" "));
    }
    
    public List<String> getColumns() {
        return columns;
    }
    
    public ListIterator<String> getColumnIterator() {
        return columns.listIterator();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        columns.forEach((word)-> {
            strBuilder.append(word).append(" ");
        });
        return strBuilder.toString();
    }
    
}
