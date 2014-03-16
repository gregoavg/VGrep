/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class MyStringUtils {

    public static String keepLastWord(String text) {
        String[] textArray = text.trim().split(" ");
        if (textArray.length > 0)
        {
            return textArray[textArray.length - 1];
        }
        return null;
    }

    public static String[] removeEmptyNodes(String[] stringArray) {
        List<String> textList = new ArrayList<>();
        for (String textNode : stringArray)
        {
            if (textNode.isEmpty() || textNode.matches(" "))
            {
                continue;
            }
            textList.add(textNode);
        }
        return textList.toArray(new String[textList.size()]);
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
