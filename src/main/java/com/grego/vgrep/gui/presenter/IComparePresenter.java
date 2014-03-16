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
import java.util.List;


/**
 *
 * @author Grigorios
 */
public interface IComparePresenter {
    
    ICompareModel getModel();
    
    void setView(ICompareView referenceView);
    
    void findReferences();
    
    void prepareForNewReference();
    
    void addFile(EContentType type, File file);
    
    void removeFile(EContentType type);
    
    String getFileName(EContentType type);
    
    List<IReference> getReferences();
    
}