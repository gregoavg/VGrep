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


/**
 *
 * @author Grigorios
 * @param <T> type of data that this class represents
 */
public abstract class AData<T> {
    
    protected final T data;

    public AData(T data) {
        this.data = data;
    }

    public T getActualData() {
        return data;
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "";
    }
          
    @SuppressWarnings("rawtypes")
    public static final AData EMPTY_DATA = new EmptyData<>(null);
    
    @SuppressWarnings("unchecked")
    public static final <T> AData<T> emptyData() {
        return (AData<T>) EMPTY_DATA;
    }
    
    /**
     * helper class to handle empty data slots on data manager
     */
    private static class EmptyData<T> extends AData<T> {

        public EmptyData(T data) {
            super(data);
        }

    }
}