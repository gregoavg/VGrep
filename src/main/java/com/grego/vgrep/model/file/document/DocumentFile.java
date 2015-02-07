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
package com.grego.vgrep.model.file.document;

import com.grego.vgrep.model.file.ADataFile;
import com.grego.vgrep.model.reader.DocumentReader;
import com.grego.vgrep.model.reader.IReader;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Implementation of <code>ADataFile</code> for document files. A document file
 * provides a document reader to the superclass. The reader is responsible to
 * parse this document and create a content that consists of lines. 
 * 
 * @author Grigorios
 */
public final class DocumentFile extends ADataFile {

    public DocumentFile(File data) {
        super(data);
    }

    public DocumentFile(String filePath) throws FileNotFoundException {
        super(filePath);
    }

    @Override
    protected IReader constructReader() {
        return new DocumentReader();
    }

}
