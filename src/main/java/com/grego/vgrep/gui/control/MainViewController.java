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

import com.grego.vgrep.gui.model.CompareModel;
import com.grego.vgrep.gui.model.ICompareModel;
import com.grego.vgrep.gui.view.manager.IViewManager;
import com.grego.vgrep.gui.view.manager.JFxViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Grigorios
 */
public class MainViewController implements Initializable {

    @FXML
    Button button;
    
    IViewManager viewManager = JFxViewManager.INSTANCE;
    
    //ICompareModel model = new CompareModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void buttonPressed(ActionEvent ae) {
       //not implemented yet
    }
    
}
