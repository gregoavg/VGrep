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

import com.grego.vgrep.gui.control.MainViewController;
import com.grego.vgrep.gui.model.IModel;
import javafx.collections.ObservableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public final class MainView extends JFxView {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);

    private IModel model = null;

    public MainView(IModel model) {
        super("/fxml/MainView.fxml");
        this.model = model;
        this.model.attachView((IView) this);
        ((MainViewController) super.controller).setModel(this.model);
    }

    @Override
    public void update() {
        LOGGER.debug("view update has been submited!!");
    }

    public IModel getModel() {
        return model;
    }

    @Override
    protected void initComponets(final ObservableMap<String, Object> componentMapper) {
        //not yet implemented
    }
}
