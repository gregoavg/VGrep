/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.manager;

import com.grego.vgreo.testRunner.JavaFXJUnit4ClassRunner;
import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.gui.view.SimpleFxView;
import javafx.stage.Stage;
import javafx.stage.Window;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Grigorios
 */
@RunWith(JavaFXJUnit4ClassRunner.class)
public class JFxWindowManagerTest extends TestCase {
    
    private final IWindowManager windowManager;
    
    public JFxWindowManagerTest() {
        windowManager = JFxWindowManager.INSTANCE;
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
        assertNotNull(aWindowManager.getCurrentDisplay());
    }

    /**
     * Test of getCurrentDisplay method, of class JFxWindowManager.
     */
    @Test
    public void testGetCurentDisplay() {
        System.out.println("getCurrentDisplay");
        IView view = new SimpleFxView();
        JFxWindowManager.INSTANCE.setDisplay(view);
        
        JFxWindowManager instance = (JFxWindowManager) windowManager;
        IView windowedView = instance.getCurrentDisplay();
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
        assertFalse(JFxWindowManager.INSTANCE.getWindow().isShowing());
    }

    /**
     * Test of setInitialWindowSize method, of class JFxWindowManager.
     */
    @Test
    public void testSetInitialWindowSize() {
        System.out.println("setInitialWindowSize");
        int width = 400;
        int height = 400;
        windowManager.setWindowSize(width, height);
        windowManager.setDisplay(new SimpleFxView());
        Stage stage = (Stage) windowManager.getWindow();
        Double height1 = stage.getHeight();
        Double width1 = stage.getWidth();
        assertEquals(width, width1.intValue());
        assertEquals(height, height1.intValue());
    }

    /**
     * Test of getWindow method, of class JFxWindowManager.
     */
    @Test
    public void testGetWindow() {
        System.out.println("getWindow");
        JFxWindowManager instance = JFxWindowManager.INSTANCE;
        Window window = (Window) windowManager.getWindow();
        assertNotNull(window);
    }

    /**
     * Test of setWindowTitle method, of class JFxWindowManager.
     */
    @Test
    public void testSetWindowTitle() {
        System.out.println("setWindowTitle");
        String title = "";
        windowManager.setTitle(title);
        String windowTitle = ((Stage)JFxWindowManager.INSTANCE.getWindow()).getTitle();
        assertEquals(title, windowTitle);
    }
    
}
