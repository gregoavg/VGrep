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
 *
 * @author Grigorios
 */
public abstract class JFxView implements IView {

    private static final Logger LOGGER = LoggerFactory.getLogger(JFxView.class);

    protected final FXMLLoader loader = new FXMLLoader();
    protected Scene scene = null;
    protected IController controller = null;

    public JFxView(String fxmlFilePath) {
        loadContents(fxmlFilePath);
    }

    @Override
    public void setVisibility(boolean state) {
        scene.getRoot().setVisible(state);
    }

    @Override
    public void dispose() {
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(new Scene(new Pane()));
        stage.hide();
    }

    private void loadContents(String fxmlFilePath) {
        try (InputStream fileAsStream = FileUtils.getFileAsResourceStream(fxmlFilePath))
        {
            scene = new Scene(loader.load(fileAsStream));
            controller = defaultController();
            
            initComponets(loader.getNamespace());
        }
        catch (IOException ex)
        {
            LOGGER.warn("Can not read file from path "+ fxmlFilePath +"!", ex);
            
        }
    }
    
    protected abstract void initComponets(final Map<String, Object> componentMapper);
    
    /**
     * Override this factory method in order to change the default controller. 
     * @return <b>JFx Controller</b> as specified in FXML file 
     */
    protected IController defaultController() {
        return loader.getController();
    }

    public Scene getScene() {
        return scene;
    }

    public FXMLLoader getLoader() {
        return loader;
    }
}
