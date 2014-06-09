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

package com.grego.vgrep.model.data;

import com.grego.vgrep.model.reader.fileReader.EFileType;
import com.grego.vgrep.utils.FileUtils;
import java.io.File;

/**
 *
 * @author Grigorios
 */
public class FileData extends AData<File> {

    public FileData(File data) {
        super(data);
    }
    
     public EFileType getFileType() {
        return FileUtils.getFileType(super.data);
    }
}
