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

package com.grego.vgrep.model.reader;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Grigorios
 */
public abstract class ADocumentReader implements IReader {

    protected File source;

    public ADocumentReader(File source) {
        this.source = source;
    }

    public ADocumentReader() {
        this.source = null;
    }

    @Override
    public void setSource(Object source) {
        if(source instanceof File)
        {
            this.source = (File) source;
        }
    }
    
    @Override
    public abstract String read() throws IOException;
    
}
