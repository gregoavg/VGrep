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

/**
 * Represents an <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC pattern</a>
 * controller. It keeps track of a model instance, in order to apply changes to it.
 * 
 * @author Grigorios
 */
public interface IController {

    /**
     * Returns the referenced model instance that this controller manages
     * 
     * @return <code>IModel</code> instance
     * @see    IModel
     * 
     */
    IModel getModel();

    /**
     * Provides a model instance to this controller
     * 
     * @param model the <code>IModel</code> instance to be managed
     * @see   IModel
     * 
     */
    void setModel(IModel model);
    
}
