/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.data.document;

import java.util.Iterator;
import java.util.List;
import static com.grego.vgrep.utils.ECompareResult.*;
import com.grego.vgrep.utils.StringUtils;
import java.util.Arrays;

/**
 *
 * @author Grego
 */
public final class Line implements Iterable<String>, Comparable<String> {

    private final List<String> columns;
    private final static String seperator = " ";
    public Line(String text) { 
        String[] splitedText = text.split(seperator);
        columns = Arrays.asList(StringUtils.removeNodes(splitedText, seperator));
    }

    public List<String> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder();
        columns.forEach((word) ->
        {
            strBuilder.append(word).append(" ");
        });
        return strBuilder.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return columns.listIterator();
    }

    @Override
    public int compareTo(String otherWord) {
        for (String word : this.columns)
        {
            if (word.equals(otherWord))
            {
                return Equal.integerValue();
            }
        }
        return NotEqual.integerValue();
    }

}
