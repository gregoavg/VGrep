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

import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;
import com.grego.vgrep.model.data.document.DocumentContent;
import com.grego.vgrep.model.data.document.DocumentContent.ContentBuilder;
import com.grego.vgrep.model.reader.fileParser.EFileType;
import com.grego.vgrep.model.reader.fileParser.IDocumentParseStrategyFactory;
import com.grego.vgrep.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import org.slf4j.LoggerFactory;

/**
 * Implementation of <code>IReader</code> for document files. This type of
 * reader is able to self-define the file type of the provided data file and
 * request the appropriate parse strategy in order to use it for traversing the
 * document. Moreover with the help of <code>ContentBuilder</code>, it collects
 * and returns the document contents to clients.
 *
 * @author Grigorios
 */
public class DocumentFileReader implements IFileReader {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DocumentFileReader.class);

    @Override
    public IFileContent<String> read(final ADataFile dataFile) {
        File sourceFile = dataFile.getSourceFile();
        DocumentContent.ContentBuilder builder = new ContentBuilder();
        final EFileType fileType = FileUtils.getFileType(sourceFile);
        IDocumentParseStrategyFactory.getInstance(fileType)
                .parse(sourceFile)
                .forEach(builder::appendLine);
        return builder.createContents();
    }

}
