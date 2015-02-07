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

import com.grego.vgrep.model.file.ADataFile;
import com.grego.vgrep.model.file.IContent;
import com.grego.vgrep.model.file.document.DocumentContent;
import com.grego.vgrep.model.file.document.DocumentContent.ContentBuilder;
import com.grego.vgrep.model.file.document.Line;
import com.grego.vgrep.model.reader.parseStrategy.DocumentParseStrategyFactory;
import com.grego.vgrep.model.reader.parseStrategy.EFileType;
import com.grego.vgrep.utils.FileUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;

/**
 * Implementation of <code>IReader</code> for document files. This type of
 * reader is able to self-define the file type of the provided data file and
 * request the appropriate parse strategy in order to use it for traversing the
 * document. Moreover with the help of <code>ContentBuilder</code>, it collects
 * and returns the document contents to clients.
 *
 * @author Grigorios
 */
public class DocumentReader implements IReader {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DocumentReader.class);

    @Override
    public IContent<Line> read(final ADataFile dataFile) {
        File sourceFile = dataFile.getSourceFile();
        DocumentContent.ContentBuilder builder = new ContentBuilder();

        final EFileType fileType = FileUtils.getFileType(sourceFile);
        final Collection<String> lines = DocumentParseStrategyFactory.getStrategy(fileType)
                .parse(sourceFile);
        lines.forEach(builder::appendLine);
        return builder.createContents();
    }

}
