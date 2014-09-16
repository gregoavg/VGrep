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
import com.grego.vgrep.gui.model.TableViewManager;
import com.grego.vgrep.gui.model.IModel;
import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.gui.view.event.FileSelectionEvent;
import com.grego.vgrep.gui.view.event.ViewEvent;
import com.grego.vgrep.model.data.EDataType;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public final class MainView extends JFxView {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);

    private final ViewModel model;

    public MainView(IModel model) {
        super("/fxml/MainView.fxml");
        this.model = (ViewModel) model;
        this.model.attachView((IView) this);
        super.controller.setModel(this.model);
    }

    @Override
    public void update() {
        sourceFilePathTextField.setText(model.getFile(EDataType.SOURCE).toString());
        targetFilePathTextField.setText(model.getFile(EDataType.TARGET).toString());
        
        sourceFileTableManager.setDataFile(model.getFile(EDataType.SOURCE));
        targetFileTableManager.setDataFile(model.getFile(EDataType.TARGET));
    }

    public IModel getModel() {
        return model;
    }

    @Override
    protected void initComponets(final Map<String, Object> componentMapper) {
        MainViewController mainViewController = (MainViewController) super.controller;
        
        sourceFilePathTextField = (TextField) componentMapper.get("sourceFilePathTextField");
        targetFilePathTextField = (TextField) componentMapper.get("targetFilePathTextField");
        
        sourceFileSelectButton = (Button) componentMapper.get("selectSourceFileButton");
        sourceFileSelectButton.setOnAction((actionEvent) -> {
            mainViewController.selectFileButtonClick(new FileSelectionEvent(EDataType.SOURCE));
        });
        
        targetFileSelectButton = (Button) componentMapper.get("selectTargetFileButton");
        targetFileSelectButton.setOnAction((actionEvent) -> {
            mainViewController.selectFileButtonClick(new FileSelectionEvent(EDataType.TARGET));
        });
        
        findReferencesButton = (Button) componentMapper.get("findReferencesButton");
        findReferencesButton.setOnAction((actionEvent)-> {
            
            mainViewController.findReferences(new ViewEvent());
        });
        
        sourceFileTableManager = new TableViewManager((TableView) componentMapper.get("sourceTableView"));
        targetFileTableManager = new TableViewManager((TableView) componentMapper.get("targetTableView"));
    }
    
    //View components declaration area
    private TextField sourceFilePathTextField;
    private TextField targetFilePathTextField;
    
    private Button sourceFileSelectButton;
    private Button targetFileSelectButton;
    private Button findReferencesButton;
    
    private TableViewManager sourceFileTableManager;
    private TableViewManager targetFileTableManager;
}
