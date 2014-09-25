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
package com.grego.vgrep.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Grigorios
 */
public final class CollectionUtils {

    /**
     * Returns the last element of list. If the given list is empty, the
     * returned value will be null.
     *
     * @param <T> Class type
     * @param collection List of elements
     * @return Last element of list
     */
    public static <T> T getLastElement(Collection<T> collection) {
        try {
            return collection != null ? new LinkedList<>(collection).getLast() : null;
        }
        catch(NoSuchElementException ex) {
            return null;
        }
    }

    public static <T> int getMaxNestedDataCount(Collection<Collection<T>> dataSet) {
        int maxElementSize = 0;
        for (Collection collection : dataSet) {
            if (maxElementSize < collection.size()) {
                maxElementSize = collection.size();
            }
        }
        return maxElementSize;
    }

    public static <T> T[] removeNodes(T[] array, T sampleNode) {
        List<T> reducedList = new ArrayList<>();
        for(T node : array) {
            if(!node.equals(sampleNode)) {
                reducedList.add(node);
            }
        }
        return (T[]) reducedList.toArray();
    }
}
