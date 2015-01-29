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

import com.grego.vgrep.app.factory.ApplicationFactory;
import com.grego.vgrep.app.launcher.ILaunchable;

import static com.grego.vgrep.app.factory.ApplicationFactory.EApplicationType.JavaFX;

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
        ILaunchable app = ApplicationFactory.getInstance(JavaFX);
        app.invokeLauncher(args);
    }

}
