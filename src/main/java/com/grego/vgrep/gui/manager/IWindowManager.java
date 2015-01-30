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

package com.grego.vgrep.gui.manager;

import com.grego.vgrep.gui.view.IView;

import javax.validation.constraints.NotNull;

/**
 * Represents a supervisor for a managed window that
 * serves as parent placeholder for views.
 * 
 * @author Grigorios
 */
public interface IWindowManager {
    
    /**
     * Sets a view as main display in the managed window
     * 
     * @param view - view that needs to be displayed
     * @see   IView
     * 
     */
    void setDisplay(IView view);
    
    /**
     * Changes managed window visibility
     * 
     * @param visible preference state 
     * 
     */
    void setVisibility(boolean visible);
    
    /**
     * Changes default window size
     * 
     * @param width  desired window width
     * @param height desired window height
     * 
     */
    void setWindowSize(int width, int height);
    
    /**
     * Returns the managed window
     * 
     * @return window object
     * 
     */
    Object getWindow();

    /**
     * Sets display title for the window
     * 
     * @param title to be displayed
     * 
     */
    void setTitle(String title);

    /**
     * Loads a custom image, addressed by the given path,
     * as main icon of the application window.
     *
     * @param path the url path to image icon
     */
    void setIcon(@NotNull String path);
}