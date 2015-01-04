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
package com.grego.vgrep.gui.view.javaFx;

import com.grego.vgrep.gui.control.IController;
import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstracted <code>IView</code> implementation for the JavaFX framework.
 * Serves as parent for all views that need to be compatible with
 * JavaFX framework and run on it's thread.
 * 
 * @author Grigorios
 * @see    IView
 */
public abstract class JFxView implements IView {
    private static final Logger LOGGER = LoggerFactory.getLogger(JFxView.class);

    protected final FXMLLoader loader = new FXMLLoader();
    protected final Scene scene;
    protected final IController controller;

    public JFxView(String fxmlFilePath) {
        scene = loadScene(fxmlFilePath);
        controller = defaultController();
        initComponets(loader.getNamespace());
    }

    @Override
    public void setVisibility(boolean state) {
        scene.getRoot().setVisible(state);
    }

    /**
     * Disposes this view instance by accessing the parent window
     * and changes it's current main display with a new, empty, stage instance
     * 
     */
    @Override
    public void dispose() {
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(new Scene(new Pane()));
        stage.hide();
    }

    /**
     * Loads content from fxml file, through loader 
     * @param fxmlFilePath
     * @return loaded scene if found, else a new instance of scene is returned
     * @see Scene
     * 
     */
    private Scene loadScene(String fxmlFilePath) {
        try (InputStream fileAsStream = FileUtils.getFileAsResourceStream(fxmlFilePath))
        {
            return new Scene(loader.load(fileAsStream));
        }
        catch (IOException ex)
        {
            LOGGER.warn("Can not read file from path " + fxmlFilePath + "!", ex);
            return new Scene(new Pane()); //if can't read from file return empty view
        }
    }

    /**
     * Initializes displayed components through a provided component map
     * @param componentMapper a map that holds Control components instances,
     * in an entry set, with each component name as key
     * 
     */
    protected abstract void initComponets(final Map<String, Object> componentMapper);

    /**
     * Override this factory method in order to change the default controller.
     *
     * @return <b>JFx Controller</b> as specified in FXML file
     * @see    IController
     * 
     */
    protected final IController defaultController() {
        return loader.getController();
    }

    /**
     * Returns the content parent of this view
     * @return display context
     * 
     */
    public Scene getScene() {
        return scene;
    }

    public FXMLLoader getLoader() {
        return loader;
    }
}
