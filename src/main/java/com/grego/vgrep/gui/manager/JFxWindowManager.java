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
package com.grego.vgrep.gui.manager;

import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.gui.view.javaFx.JFxView;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton instance implementation of <code>IWindowManager</code> 
 * implementation for the JavaFX framework. It encapsules a JavaFX stage instance
 * as a root window, that serves as parent for JavaFX view instances.
 *
 * @author Grigorios
 */
public enum JFxWindowManager implements IWindowManager {
    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(JFxWindowManager.class);

    // serves as root window for this Manager
    private final Stage stage = new Stage();
    
    private JFxView currentDisplay = null;

    // default stage dimentions
    private Point2D stageDimentions = new Point2D(800, 600);

    private JFxWindowManager() {
        stage.setWidth(stageDimentions.getX());
        stage.setHeight(stageDimentions.getY());
    }

    @Override
    public void setDisplay(IView view) {
        if (view instanceof JFxView) {
            currentDisplay = (JFxView) view;
            stage.setScene(currentDisplay.getScene());

            LOGGER.info("Display: " + view.toString() + " added to Window Manager");
        }
    }

    public IView getCurentDisplay() {
        return currentDisplay;
    }

    @Override
    public void setVisibility(boolean visible) {
        if (visible) {
            stage.show();
            LOGGER.info("Window Manager is visible");
        } else {
            stage.hide();
            LOGGER.info("Window Manager is invisible by user request");
        }
    }

    @Override
    public void setWindowSize(int width, int height) {
        stageDimentions = new Point2D(width, height);
        stageDimentionsChanged();
    }

    @Override
    public Window getWindow() {
        return stage;
    }

    @Override
    public void setTitle(String title) {
        stage.setTitle(title);
    }
    
    /**
     * Updates stage size after the <code>setWindowSize</code> method call.
     */
    private void stageDimentionsChanged() {
        LOGGER.info("Window Manager's root window size, changed by user request");
        LOGGER.info("New Window dimentions are set to: "
                +"Width: " + stageDimentions.getX()
                +" Hight: " + stageDimentions.getY());
        stage.setWidth(stageDimentions.getX());
        stage.setHeight(stageDimentions.getY());
    }

}
