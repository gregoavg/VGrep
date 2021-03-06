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
package com.grego.vgrep.model.file;

import com.grego.vgrep.model.reader.IReader;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

/**
 * Abstract model implementation of file. This abstraction works on top of
 * {@link java.io.File}, as as a proxy and it holds reference to the real
 * file and it's path. Moreover with the use of file reader, it is possible to
 * read it's contents whenever clients demand it (lazy initialization of content).
 *
 * @author Grigorios
 *
 */
public abstract class ADataFile {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ADataFile.class);

    protected final File sourceFile;

    protected final IReader reader = Objects.requireNonNull(constructReader());

    // Proper declaration for the lazy initialization purpose
    protected volatile IContent content = null;

    public ADataFile() {
        sourceFile = null;
    }

    public ADataFile(File data) {
        sourceFile = data;
    }

    public ADataFile(String filePath) {
        sourceFile = Objects.requireNonNull(new File(filePath));
    }

    /**
     * Returns the source file that this wrapper holds.
     * 
     * @return the reference to the real file, as <code>java.io.File</code> 
     * @see File
     * 
     */
    public File getSourceFile() {
        return sourceFile;
    }

    /**
     * Factory method to provide reader for file
     *
     * @return reader instance
     */
    protected abstract IReader constructReader();

    /**
     * Double-check idiom for lazy initialization of file content.
     * 
     * @return content of this file
     * @see IContent
     * 
     */
    public IContent getContent() {
        IContent result = content;
        if (result == null) { // First check (no locking)
            synchronized (this) {
                result = content;
                if (result == null) { // Second check (with locking)
                    content = result = reader.read(this);
                }
            }
        }
        return result;
    }

    private static final ADataFile EMPTY_DATA_FILE = new EmptyDataFile();

    /**
     * Null object pattern for data file. When no real file exists, an empty one
     * will be provided to fulfill client requests.
     * 
     * @return empty data file
     * @see EmptyDataFile
     */
    @SuppressWarnings("unchecked")
    public static final ADataFile getEmptyDataFile() {
        return EMPTY_DATA_FILE;
    }

    @Override
    public String toString() {
        return sourceFile != null ? sourceFile.getName() : "";
    }

    //equality check
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.sourceFile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ADataFile other = (ADataFile) obj;
        return Objects.equals(this.sourceFile, other.sourceFile);
    }

    /**
     * Helper class to handle empty sourceFile slots on sourceFile manager.
     * This implementation makes use of the null object pattern in order to eliminate
     * conditional statements that check for data existence.
     */
    private static final class EmptyDataFile extends ADataFile {

        @Override
        protected IReader constructReader() {
            return emptyReader -> IContent.empty();
        }
    }
}
