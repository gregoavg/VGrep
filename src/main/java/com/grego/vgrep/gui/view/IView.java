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

package com.grego.vgrep.gui.view;

/**
 * Represents an <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC pattern</a>
 * view, capable of refreshing it's context after
 * a change notification event, invokes it's update method
 * 
 * @author Grigorios
 */
public interface IView {
 
    /**
     * Changes visibility of this view.
     * @param state desired visibility state.
     * 
     */
    void setVisibility(boolean state);
    
    void dispose();
    
    /**
     * Notifies view for changes in model, that it may have direct interest on.
     * 
     */
    void update();
    
}
