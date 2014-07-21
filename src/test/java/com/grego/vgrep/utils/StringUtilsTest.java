/*
 * Copyright 2014 Grigorios.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grego.vgrep.utils;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Grigorios
 */
public class StringUtilsTest extends TestCase {
    
    public StringUtilsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of keepLastWord method, of class StringUtils.
     */
    public void testKeepLastWord() {
        System.out.println("keepLastWord");
        String text = "My goal is to test";
        String expResult = "test";
        String result = StringUtils.keepLastWord(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeEmptyNodes method, of class StringUtils.
     */
    public void testRemoveEmptyNodes() {
        System.out.println("removeEmptyNodes");
        String[] stringArray = { "To", " ", "Treno", " ", "", "Einai", " ", null, "", null }; //size: 8
        int expResult = 3;
        int result = StringUtils.removeEmptyNodes(stringArray).length;
        assertEquals(expResult, result);
    }

    /**
     * Test of textToLineCollection method, of class StringUtils.
     */
    public void testTextToLineCollection() {
        System.out.println("textToLineCollection");
        String text = "My goal is to test";
        int expResult = 5;
        int result = StringUtils.textToLineCollection(text, " ").size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxLineWordCount method, of class StringUtils.
     */
    public void testGetMaxLineWordCount() {
        System.out.println("getMaxLineWordCount");
        List<String> dataRows = new ArrayList<>(4);
        dataRows.add("my goal is to test");
        dataRows.add("this helps me work better");
        dataRows.add("with less unexpected mistakes");
        dataRows.add("that's my way of ninja!");
        int expResult = 5;
        int result = StringUtils.getMaxLineWordCount(dataRows, " ");
        assertEquals(expResult, result);
    }
    
}
