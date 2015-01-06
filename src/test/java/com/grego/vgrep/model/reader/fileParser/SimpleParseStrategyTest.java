/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grego
 */
public class SimpleParseStrategyTest {

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, for TXT file
     */
    @Test
    public void testParseTxt() {
        System.out.println("parse txt file...");
        File file = new File("src/test/resources/files/textFile.txt");
        if(file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getPath());
        }
        SimpleParseStrategy parser = new SimpleParseStrategy();
        Collection<String> lines = parser.parse(file);
        lines.forEach(System.out::println);
        
        assertFalse(lines.isEmpty());
    }
    
    /**
     * Test of parse method for a null file reference.
     */
    @Test
    public void testParseNullFile() {
        System.out.println("parse null file...");
        File file = null;
        SimpleParseStrategy parser = new SimpleParseStrategy();
        Collection<String> lines = parser.parse(file);
        lines.forEach(System.out::println);
        
        assertTrue(lines.isEmpty());
    }
    
}
