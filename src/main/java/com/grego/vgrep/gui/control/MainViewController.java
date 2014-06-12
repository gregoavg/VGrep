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

package com.grego.vgrep.gui.control;

import com.grego.vgrep.gui.model.IModel;
import com.grego.vgrep.gui.view.manager.IViewManager;
import com.grego.vgrep.gui.view.manager.JFxViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public class MainViewController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainViewController.class);
    
    private final IViewManager viewManager = JFxViewManager.INSTANCE;
    private IModel model = null;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public IModel getModel() {
        return model;
    }

    public void setModel(IModel model) {
        this.model = model;
    }
    
    @FXML
    public void sourceFilePathClick(ActionEvent event) {
        //test MVC request to update view need to be changed with actual request
        model.fireDataChanged();
    }
   
}
