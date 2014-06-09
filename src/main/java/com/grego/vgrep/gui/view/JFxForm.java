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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class JFxForm implements IView {

    private static final Logger LOGGER = LoggerFactory.getLogger(JFxForm.class);

    protected Parent rootPane;

    public JFxForm(String fxmlFilePath) {
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

    private void loadContents(String fxmlFilePath) {
        try
        {
            rootPane = FXMLLoader.load(getClass().getResource("/fxml/MainFXML.fxml"));
        }
        catch (IOException ex)
        {
            LOGGER.warn("I/O exception. Can not load contents from fxml file!",ex);

        }
    }

    public Parent getRootPane() {
        return rootPane;
    }
    
}
