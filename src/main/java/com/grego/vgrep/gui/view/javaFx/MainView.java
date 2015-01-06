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

import com.grego.vgrep.gui.control.MainViewController;
import com.grego.vgrep.gui.model.IModel;
import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.event.FileSelectionEvent;
import com.grego.vgrep.event.FindReferencesEvent;
import com.grego.vgrep.gui.model.IComponentHandler;
import com.grego.vgrep.gui.model.table.TableViewHandler;
import com.grego.vgrep.model.data.EDataLabel;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaFX view implementation that serves as main view for this application.
 * 
 * @author Grigorios
 */
public final class MainView extends JFxView {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);

    private final ViewModel model;

    public MainView(IModel model) {
        super("/fxml/MainView.fxml");
        this.model = (ViewModel) model;
        this.model.attachView(MainView.this);
        super.controller.setModel(this.model);
        LOGGER.info("Main View initialization finished");
    }

    @Override
    public void update() {
        sourceFilePathTextField.setText(model.getFile(EDataLabel.SOURCE).toString());
        targetFilePathTextField.setText(model.getFile(EDataLabel.TARGET).toString());
        
        sourceTableHandler.setDataModel(model.getFile(EDataLabel.SOURCE));
        targetTableHandler.setDataModel(model.getFile(EDataLabel.TARGET));
        LOGGER.info("Main View updated by model request");
    }

    public IModel getModel() {
        return model;
    }

    @Override
    protected void initComponets(final Map<String, Object> componentMap) {
        MainViewController mainViewController = (MainViewController) super.controller;
        
        sourceFilePathTextField = (TextField) componentMap.get("sourceFilePathTextField");
        targetFilePathTextField = (TextField) componentMap.get("targetFilePathTextField");
        
        sourceFileSelectButton = (Button) componentMap.get("selectSourceFileButton");
        sourceFileSelectButton.setOnAction((actionEvent) -> {
            mainViewController.selectFileButtonClick(new FileSelectionEvent(EDataLabel.SOURCE));
        });
        
        targetFileSelectButton = (Button) componentMap.get("selectTargetFileButton");
        targetFileSelectButton.setOnAction((actionEvent) -> {
            mainViewController.selectFileButtonClick(new FileSelectionEvent(EDataLabel.TARGET));
        });
        
        findReferencesButton = (Button) componentMap.get("findReferencesButton");
        findReferencesButton.setOnAction((actionEvent)-> {
            final FindReferencesEvent event = new FindReferencesEvent();
            event.setPatterns(sourceTableHandler.getSelectedValues());
            
            mainViewController.findReferences(event);
        });
        
        sourceTableHandler = new TableViewHandler((TableView) componentMap.get("sourceTableView"));
        targetTableHandler = new TableViewHandler((TableView) componentMap.get("targetTableView"));
        
        LOGGER.info("Main View components hava been initialized");
    }
    
    //View components declaration area
    private TextField sourceFilePathTextField;
    private TextField targetFilePathTextField;
    
    private Button sourceFileSelectButton;
    private Button targetFileSelectButton;
    private Button findReferencesButton;
    
    private IComponentHandler sourceTableHandler;
    private IComponentHandler targetTableHandler;
}
