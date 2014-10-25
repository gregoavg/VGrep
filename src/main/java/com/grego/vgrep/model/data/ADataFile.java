/*
 * Copyright 2014 Grigorios.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this sourceFile except in compliance with the License.
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
package com.grego.vgrep.model.data;

import com.grego.vgrep.model.reader.AFileReader;
import com.grego.vgrep.model.reader.AFileReader.EmptyReader;
import java.io.File;
import java.util.Objects;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public abstract class ADataFile {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ADataFile.class);
    
    protected final File sourceFile;
    protected final AFileReader reader = Objects.requireNonNull(constructReader());
    
    public ADataFile() {
        sourceFile = null;
    }

    @SuppressWarnings("unchecked")
    public ADataFile(File data) {
        sourceFile = data;
        reader.setSource(this);
    }

    @SuppressWarnings("unchecked")
    public ADataFile(String filePath) {
        sourceFile = Objects.requireNonNull(new File(filePath));
        reader.setSource(this);
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public AFileReader getReader() {
        return reader;
    }
    
    /**
     * Factory method to provide reader for file
     * @return reader instance
     */
    protected abstract AFileReader constructReader();

    @SuppressWarnings("rawtypes")
    private static final ADataFile EMPTY_DATA_FILE = new EmptyDataFile(null);

    @SuppressWarnings("unchecked")
    public static final ADataFile emptyData() {
        return EMPTY_DATA_FILE;
    }

    @Override
    public String toString() {
        return sourceFile != null ? sourceFile.getName() : "";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.sourceFile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final ADataFile other = (ADataFile) obj;
        return Objects.equals(this.sourceFile, other.sourceFile);
    }
    
    /**
     * helper class to handle empty sourceFile slots on sourceFile manager
     */
    private static final class EmptyDataFile extends ADataFile {

        public EmptyDataFile(File data) {
            super(data);
        }

        @Override
        protected AFileReader constructReader() {
            return new EmptyReader();
        }
    }
}
