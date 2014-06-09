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

import com.grego.vgrep.model.file.EDataType;
import com.grego.vgrep.model.file.DataManager;
import com.grego.vgrep.model.file.IDataManager;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.data.AData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class CompareModel implements ICompareModel {
    
    private final IDataManager dataManager = new DataManager();
    private List<IReference> references = new ArrayList<>();
    
    @Override
    public void addData(EDataType dataType, AData data) {
        dataManager.addData(dataType, data);
    }
    
    @Override
    public void remove(EDataType dataType) {
        dataManager.remove(dataType);
    }
    
    @Override
    public void clearFiles() {
        dataManager.clearData();
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
}
