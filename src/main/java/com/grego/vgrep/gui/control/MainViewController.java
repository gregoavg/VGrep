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

import com.grego.vgrep.event.FileSelectionEvent;
import com.grego.vgrep.event.FindReferencesEvent;
import com.grego.vgrep.gui.manager.IWindowManager;
import com.grego.vgrep.gui.manager.JFxWindowManager;
import com.grego.vgrep.gui.model.IModel;
import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.SimpleReference;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.EDataLabel;
import com.grego.vgrep.model.data.document.Line;
import com.grego.vgrep.model.holder.IHolder;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Implementation of <code>IController</code> for the JavaFX framework.
 * Serves as <code>MainView</code> controller and it can be also accessed through
 * <code>FXMLLoader</code> as it implements <code>Initializable</code> interface.
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

    public void selectFileButtonClick(final FileSelectionEvent event) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File selectedFile = fileChooser.showOpenDialog((Window) viewManager.getWindow());
        if (selectedFile != null) {
            model.addFile(event.getDataLabel(), selectedFile);
        }
    }

    @SuppressWarnings("unchecked")
    public void findReferences(final FindReferencesEvent event) {
        final ADataFile targetFile = model.getFile(EDataLabel.TARGET);
        final ADataFile sourceFile = model.getFile(EDataLabel.SOURCE);
        
        List<IReference> references = new ArrayList<>();


        for(IHolder<String> pattern : event.getPatterns()) {
            for(Line line : (List<Line>) targetFile.getContent().list()) {
                for(String word : line.getColumns()) {
                    if(word.equals(pattern.getValue())) {
                        references.add(new SimpleReference(pattern.getValue(), line.toString()));
                    }
                }
            }
            
        }
        //TODO: optimization
        /*for (Comparable line : (List<Comparable>) file.getContent().list()) {
            for (Comparable sourceLine : (List<Comparable>) sourceFile.getContent().list()) {
                if (line.compareTo(sourceLine) == Equal.getIntegerValue()) {
                    references.add(new SimpleReference(sourceLine.toString(), line.toString()));
                }
            }
        }*/

        System.out.println("List of References: ");
        System.out.println("Total references found: " + references.size());
        references.forEach((IReference reference) -> {
            LOGGER.info(reference.toString());
        });
    }

}
