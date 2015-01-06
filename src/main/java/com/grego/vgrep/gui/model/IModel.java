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

/**
 * Represents an <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC pattern</a>
 * model. It is possible for <code>IView</code> type views to subscribe
 * at this model and get updates whenever model data change.
 * 
 * @author Grigorios
 */
public interface IModel {

    /**
     * Appends a view to this model, in order to get updates
     * when model data change.
     * 
     * @param view the view that needs to subscribe at this model. 
     * @see   IView
     * 
     */
    void attachView(IView view);
    
    /**
     * Removes the given view from the model's subscription list.
     * This view will <b>no longer</b> get updates when model data changes.
     * 
     * @param view 
     * @see   IView
     */
    void detachView(IView view);
    
    /**
     * Notifies attached/subscribed views that model's data has changed.
     * 
     */
    void fireDataChanged();
}
