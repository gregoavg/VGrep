/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import java.util.Collection;

/**
 *
 * @author Grigorios
 */
public final class TableUtils {

    public static int getMaxColSize(Collection<String> data) {
        int maxColSize = 0;
        for (String line : data)
        {
            String[] lineWords = line.split(" ");
            if (lineWords.length > maxColSize)
            {
                maxColSize = lineWords.length;
            }
        }
        return maxColSize;
    }

}
