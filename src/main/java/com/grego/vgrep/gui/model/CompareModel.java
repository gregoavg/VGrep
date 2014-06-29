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
import com.grego.vgrep.model.data.DataManager;
import com.grego.vgrep.model.data.IDataManager;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.data.AData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public final class CompareModel implements IModel {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CompareModel.class);

    private final Set<IView> attachedViews = new HashSet<>();
    private final IDataManager dataManager = new DataManager();
    private List<IReference> references = new ArrayList<>();

    @Override
    public void addData(EDataType dataType, AData data) {
        dataManager.addData(dataType, data);
        fireDataChanged();
    }

    @Override
    public void remove(EDataType dataType) {
        dataManager.remove(dataType);
        fireDataChanged();
    }

    @Override
    public void clearData() {
        dataManager.clearData();
        fireDataChanged();
    }

    @Override
    public AData getData(EDataType contentType) {
        return dataManager.getData(contentType);
    }

    @Override
    public List<IReference> getReferences() {
        return references;
    }

    @Override
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
