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

import com.grego.vgrep.model.reader.fileParser.IDocumentParseStrategy;
import com.grego.vgrep.model.data.document.DocumentContents;
import com.grego.vgrep.model.reader.fileParser.IDocumentParseStrategyFactory;
import com.grego.vgrep.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public class DocumentFileReader extends AFileReader {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DocumentFileReader.class);

    @Override
    public DocumentContents read() {
        if (dataFile.hasFile()) {
            File sourceFile = dataFile.getSourceFile();
            try {
                IDocumentParseStrategy parseStrategy = IDocumentParseStrategyFactory
                        .getInstance(FileUtils.getFileType(sourceFile));
                return parseStrategy.parse(sourceFile);
            } 
            catch (IOException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
        return new DocumentContents();
    }

}
