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
import com.grego.vgrep.event.FileSelectionEvent;
import com.grego.vgrep.event.FindReferencesEvent;
import com.grego.vgrep.gui.manager.IWindowManager;
import com.grego.vgrep.gui.manager.JFxWindowManager;
import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.holder.IHolder;
import com.grego.vgrep.model.SimpleReference;
import com.grego.vgrep.model.data.EDataType;
import com.grego.vgrep.model.data.document.DocumentFile;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.utils.ECompareResult;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public final class MainViewController implements IController, Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainViewController.class);

    private final IWindowManager viewManager = JFxWindowManager.INSTANCE;
    private ViewModel model = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //not implemented, used by JavaFx framework
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void setModel(IModel model) {
        this.model = (ViewModel) model;
    }

    public void selectFileButtonClick(FileSelectionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File selectedFile = fileChooser.showOpenDialog((Window) viewManager.getWindow());
        if (selectedFile != null)
        {
            model.addFile(event.getDataType(), selectedFile);
        }
    }

    public void findReferences(final FindReferencesEvent event) {
        final DocumentFile document =  (DocumentFile) model.getFile(EDataType.TARGET);
        final List<IHolder> wordPatterns = event.getPatterns();
        List<IReference> references = new ArrayList<>();
        
        //TODO: optimization
        for(Line line : document.getContents().getLines()) {
            for(IHolder<String> wordPattern : wordPatterns) {
                if(line.compareTo(wordPattern.getValue()) == ECompareResult.Equal.toInteger()) {
                    references.add(new SimpleReference(wordPattern.getValue(), line.toString()));
                }
            }
        }
        
        System.out.println("List of References: ");
        references.forEach((IReference reference) -> {
            LOGGER.info(reference.toString());
        });
    }

}
