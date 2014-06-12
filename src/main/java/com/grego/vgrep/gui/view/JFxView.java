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
package com.grego.vgrep.gui.view;

import java.io.IOException;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class JFxView implements IView {

    private static final Logger LOGGER = LoggerFactory.getLogger(JFxView.class);
    
    protected final FXMLLoader loader = new FXMLLoader();
    protected Parent rootPane = null;
    protected Object controller = null;

    public JFxView(String fxmlFilePath) {
        loadContents(fxmlFilePath);
    }
    
    @Override
    public void setVisibility(boolean state) {
        rootPane.setVisible(state);
    }

    @Override
    public void dispose() {
        //not implemented
    }
    
    protected abstract void initComponets(final ObservableMap<String, Object> componentMapper);

    private void loadContents(String fxmlFilePath) {
        try
        {
            rootPane = loader.load(getClass().getResource("/fxml/MainFXML.fxml").openStream());
            controller = loader.getController();
            
            initComponets(loader.getNamespace());
        }
        catch (IOException ex)
        {
            LOGGER.warn("I/O exception. Can not load contents from fxml file!",ex);
        }
    }

    public Parent getRootPane() {
        return rootPane;
    }

    public FXMLLoader getLoader() {
        return loader;
    }
}