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

package com.grego.vgrep.model.file;

/**
 * Enumeration of labels that define data usage. A file could be labeled as
 * source or target. Source data content is used as parameter and target data
 * as context. This is helpful for the reference extraction process,
 * as source data parameters would be compared with target data.
 * 
 * @author Grigorios
 * 
 */
public enum EDataLabel {
    SOURCE,
    TARGET;
}
