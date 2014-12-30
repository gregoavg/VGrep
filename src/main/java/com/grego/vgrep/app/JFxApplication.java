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
package com.grego.vgrep.app;

import com.grego.vgrep.app.launcher.ILaunchable;
import com.grego.vgrep.gui.manager.IWindowManager;
import com.grego.vgrep.gui.manager.JFxWindowManager;
import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.gui.view.IView;
import com.grego.vgrep.gui.view.javaFx.MainView;
import java.util.Objects;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public class JFxApplication extends Application implements ILaunchable {

    private static final Logger LOGGER = LoggerFactory.getLogger(JFxApplication.class);

    
    
    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("Application started");
        stage.close();

        final IWindowManager windowManager = JFxWindowManager.INSTANCE;

        IView mainView = new MainView(new ViewModel());
        windowManager.setWindowSize(600, 400);
        windowManager.setDisplay(mainView);
        windowManager.setWindowTitle("Visual File Grep");
        windowManager.setVisibility(true);
    }

    @Override
    public synchronized void invokeLauncher(String[] args) {
        String[] arguments = Objects.requireNonNull(args);
        Application.launch(arguments);
    }
}
