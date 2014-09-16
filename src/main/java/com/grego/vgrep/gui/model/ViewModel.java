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

import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.model.data.EDataType;
import com.grego.vgrep.model.data.SimpleFileManager;
import com.grego.vgrep.model.data.IFileManager;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.document.DocumentFile;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public final class ViewModel implements IModel {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ViewModel.class);

    private final Set<IView> attachedViews = new HashSet<>();
    private final IFileManager fileManager = new SimpleFileManager();
    private List<IReference> references = new ArrayList<>();

    public void addFile(EDataType dataType, File file) {
        fileManager.addFile(dataType, new DocumentFile(file));
        fireDataChanged();
    }

    public void remove(EDataType dataType) {
        fileManager.remove(dataType);
        fireDataChanged();
    }

    public void clearData() {
        fileManager.clearData();
        fireDataChanged();
    }

    public ADataFile getFile(EDataType dataType) {
        return fileManager.getFile(dataType);
    }

    public List<IReference> getReferences() {
        return references;
    }

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