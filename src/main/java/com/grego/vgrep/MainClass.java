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

import com.grego.vgrep.gui.model.ViewModel;
import com.grego.vgrep.gui.view.MainView;
import com.grego.viewmanager.application.ApplicationFactory;
import static com.grego.viewmanager.application.ApplicationFactory.EApplicationType.JavaFX;
import com.grego.viewmanager.application.IApplication;
import com.grego.viewmanager.mvc.IView;
import com.grego.viewmanager.window.IWindowManager;

//static import of application types
/**
 * Application's main class
 *
 * @author Grigorios
 */
public final class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IApplication app = ApplicationFactory.getInstance(JavaFX);
        
        app.onStart((IWindowManager windowManager) -> {
            final IView mainView = new MainView(new ViewModel());
            windowManager.setWindowSize(600, 400);
            windowManager.setDisplay(mainView);
            windowManager.setIcon("/images/logo.png");
            windowManager.setTitle("Visual File Grep");
            windowManager.setVisibility(true);
        });
        
        app.invokeLauncher(args);
    }

}
