/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.manager;

import com.grego.vgrep.gui.view.IView;
import com.grego.vgreo.testRunner.JavaFXJUnit4ClassRunner;
import com.grego.vgrep.gui.view.SimpleFxView;
import javafx.stage.Stage;
import javafx.stage.Window;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Grigorios
 */
@RunWith(JavaFXJUnit4ClassRunner.class)
public class JFxWindowManagerTest {
    
    private final IWindowManager windowManager;
    
    public JFxWindowManagerTest() {
        windowManager = JFxWindowManager.INSTANCE;
    }
    
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
     * Test of setDisplay method, of class JFxWindowManager.
     */
    @Test
    public void testSetDisplay() {
        System.out.println("setDisplay");
        IView view = new SimpleFxView();
        JFxWindowManager aWindowManager = (JFxWindowManager) windowManager;
        aWindowManager.setDisplay(view);
        Assert.assertNotNull(aWindowManager.getCurentDisplay());
    }

    /**
     * Test of getCurentDisplay method, of class JFxWindowManager.
     */
    @Test
    public void testGetCurentDisplay() {
        System.out.println("getCurentDisplay");
        IView view = new SimpleFxView();
        JFxWindowManager.INSTANCE.setDisplay(view);
        
        JFxWindowManager instance = (JFxWindowManager) windowManager;
        IView windowedView = instance.getCurentDisplay();
        assertEquals(view, windowedView);
    }

    /**
     * Test of setVisibility method, of class JFxWindowManager.
     */
    @Test
    public void testSetVisibility() {
        System.out.println("setVisibility");
        boolean visible = false;
        IWindowManager instance = windowManager;
        instance.setVisibility(visible);
        Assert.assertFalse(JFxWindowManager.INSTANCE.getWindow().isShowing());
    }

    /**
     * Test of setInitialWindowSize method, of class JFxWindowManager.
     */
    @Test
    public void testSetInitialWindowSize() {
        System.out.println("setInitialWindowSize");
        double width = 400;
        double height = 400;
        windowManager.setWindowSize(width, height);
        windowManager.setDisplay(new SimpleFxView());
        Stage stage = (Stage) windowManager.getWindow();
        double height1 = stage.getHeight();
        double width1 = stage.getWidth();
        Assert.assertEquals(width, width1);
        Assert.assertEquals(height, height1);
    }

    /**
     * Test of getWindow method, of class JFxWindowManager.
     */
    @Test
    public void testGetWindow() {
        System.out.println("getWindow");
        JFxWindowManager instance = JFxWindowManager.INSTANCE;
        Window window = (Window) windowManager.getWindow();
        Assert.assertNotNull(window);
    }

    /**
     * Test of setWindowTitle method, of class JFxWindowManager.
     */
    @Test
    public void testSetWindowTitle() {
        System.out.println("setWindowTitle");
        String title = "";
        windowManager.setWindowTitle(title);
        String windowTitle = ((Stage)JFxWindowManager.INSTANCE.getWindow()).getTitle();
        Assert.assertEquals(title, windowTitle);
    }
    
}
