/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class StringUtils {

    public static String keepLastWord(String text) {
        String[] textArray = text.trim().split(" ");
        return CollectionUtils.getLastElement(Arrays.asList(textArray));
    }

    public static String[] removeEmptyNodes(String[] stringArray) {
        List<String> textList = Arrays.asList(stringArray);
        return textList.stream()
                .filter((node) -> {
                    return node != null ? !(node.isEmpty() || node.matches(" ")) : false;
                })
                .toArray((elements) -> {
                    return new String[elements];
                });
    }

    public static Collection<String> textToLineCollection(String text, String lineSeperator) {
        String[] lineArray = text.split(lineSeperator);
        Collection<String> lineCollection = Arrays.asList(lineArray);
        return lineCollection;
    }

    public static int getMaxLineWordCount(Collection<String> dataRows, String splitter) {
        int maxWordCount = 0;
        for (String line : dataRows)
        {
            String[] lineWords = line.split(splitter);
            if (lineWords.length > maxWordCount)
            {
                maxWordCount = lineWords.length;
            }
        }
        return maxWordCount;
    }
}
