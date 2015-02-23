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
package com.grego.vgrep.gui.model;

import com.grego.viewmanager.mvc.IModel;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.file.ADataFile;
import com.grego.vgrep.model.file.EDataLabel;
import com.grego.vgrep.model.file.IFileManager;
import com.grego.vgrep.model.file.SimpleFileManager;
import com.grego.vgrep.model.file.document.DocumentFile;
import com.grego.viewmanager.mvc.IView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <Code>IModel</code> implementation, for modeling data that need to be
 * represented by a view.
 * @author Grigorios
 */
public final class ViewModel implements IModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewModel.class);

    private final Set<IView> attachedViews = new HashSet<>();
    
    // Simple placeholder for files
    private final IFileManager fileManager = new SimpleFileManager();
    
    private List<IReference> references = new ArrayList<>();

    /**
     * Attaches file to the file manager
     * 
     * @param dataLabel reference type of a file instance.
     * @param file the file instance to be held by the manager
     * @see   EDataLabel
     * 
     */
    public void addFile(EDataLabel dataLabel, File file) {
        fileManager.addFile(dataLabel, new DocumentFile(file));
        fireDataChanged();
    }

    /**
     * Removes a file from the file manager
     * 
     * @param dataLabel reference type of a file instance.
     * @see   EDataLabel
     * 
     */
    public void remove(EDataLabel dataLabel) {
        fileManager.remove(dataLabel);
        fireDataChanged();
    }

    /**
     * remove all files in file manager
     */
    public void clearData() {
        fileManager.removeAll();
        fireDataChanged();
    }

    /**
     * Retrieves an open file from manager
     * 
     * @param  dataLabel reference type of a file instance.
     * @return a requested file instance from file manager or 
     *         empty file if none, of this data type, exists in file manager. 
     * @see    EDataLabel
     * 
     */
    public ADataFile getFile(EDataLabel dataLabel) {
        return fileManager.getFile(dataLabel);
    }

    /**
     * Returns all references found between the compared files
     * 
     * @return list of references found 
     *         or empty list if no references found. 
     * @see    IReference
     * 
     */
    public List<IReference> getReferences() {
        return references;
    }

    /**
     * Sets all references found between the compared files
     * 
     * @param references list of references 
     * @see IReference
     * 
     */
    public void setReferences(List<IReference> references) {
        this.references = references;
    }

    @Override
    public void attachView(IView view) {
        attachedViews.add(view);
    }

    @Override
    public void detachView(IView view) {
        attachedViews.remove(view);
    }

    @Override
    public void fireDataChanged() {
        attachedViews.forEach(IView::update);
    }
}