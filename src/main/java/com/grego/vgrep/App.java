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
package com.grego.vgrep;

import com.grego.vgrep.gui.view.manager.JFxViewManager;
import com.grego.vgrep.gui.view.MainView;
import com.grego.vgrep.gui.view.manager.IViewManager;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public class App extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    private final IViewManager viewManager = JFxViewManager.INSTANCE;
    
    /**
     *
     * @param primaryStage
     * @throws java.io.IOException
     */
    //@Override
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.close();
        
        viewManager.setDisplay(new MainView());
        viewManager.setVisibility(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
