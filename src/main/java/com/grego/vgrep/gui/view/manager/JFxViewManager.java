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

package com.grego.vgrep.gui.view.manager;

import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.gui.view.JFxView;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Singleton View Manager
 * @author Grigorios
 */
public enum JFxViewManager implements IViewManager {
    INSTANCE;

    private final Stage stage = new Stage();
    private JFxView currentDisplay = null;
    
    //default stage dimentions
    private Point2D stageDimentions = new Point2D(stage.getWidth(), stage.getHeight()) ;

    @Override
    public void setDisplay(IView view) {
        if(view instanceof JFxView)
        {
            if(currentDisplay != null)
            {
                stageDimentions = new Point2D(stage.getWidth(), stage.getHeight());
            }
            currentDisplay = (JFxView) view;
            stage.setScene(new Scene(currentDisplay.getRootPane()));
            
            stage.setWidth(stageDimentions.getX());
            stage.setHeight(stageDimentions.getY());
            //stage.get
        }
    }
    
    public IView getCurentDisplay() {
        return currentDisplay;
    }

    @Override
    public void setVisibility(boolean visible) {
        if(visible)
        {
            stage.show();
        }
        else
        {
            stage.hide();
        }
    }
    
    @Override
    public void setDefaultViewDimentions(double width, double height) {
        stageDimentions = new Point2D(width, height);
    }
}
