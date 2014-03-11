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
package com.grego.vgrep.gui.presenter;

import com.grego.vgrep.gui.ICompareView;
import com.grego.vgrep.gui.model.ICompareModel;
import com.grego.vgrep.model.EContentType;
import com.grego.vgrep.model.IReference;
import java.io.File;
import java.util.Collection;

public class ComparePresenter implements IComparePresenter {

    private final ICompareModel model;
    private ICompareView view;

    public ComparePresenter(ICompareModel model) {
        this.model = model;
    }

    @Override
    public ICompareModel getModel() {
        return model;
    }

    @Override
    public void setView(ICompareView view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void findReferences() {
        //Not implemented yet
    }

    @Override
    public void prepareForNewReference() {
        model.clearFiles();
        view.update();
    }

    @Override
    public void addFile(EContentType type, File file) {
        model.addFile(type, file);
        view.update();
    }

    @Override
    public String getFileName(EContentType type) {
        File file = model.getFileHolder(type).getFile();
        return file != null ? file.getName() : "";
    }

    @Override
    public Collection<IReference> getReferences() {
        return model.getReferences();
    }

    @Override
    public void removeFile(EContentType type) {
        model.getFileHolder(type).removeFile();
    }

}
