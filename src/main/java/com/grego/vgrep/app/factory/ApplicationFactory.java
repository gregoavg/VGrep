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
package com.grego.vgrep.app.factory;

import com.grego.vgrep.app.JFxApplication;
import com.grego.vgrep.app.launcher.ILaunchable;

/**
 * Factory method to provide clients with application instances.
 * 
 * @author Grigorios
 */
public final class ApplicationFactory {

    /**
     * Returns an application instance, defined by a given application type.
     * 
     * @param appType the application type to be instantiated and returned
     * @return        the requested application instance or the default one 
     *                if no application of this type exists.
     * @see           EApplicationType
     * 
     */
    public static ILaunchable getInstance(EApplicationType appType) {
        switch (appType) {
            case JavaFX:
                return new JFxApplication();
            default:
                return new JFxApplication();
        }
    }
    
    /**
     * Enumeration of application types that <code>ApplicationFactory</code>
     * is capable to support.
     * 
     */
    public static enum EApplicationType {
        JavaFX;
    }
    
}
