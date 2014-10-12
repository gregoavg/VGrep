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

package com.grego.vgrep.event;

import java.util.Objects;

/**
 *
 * @author Grigorios
 */
public abstract class ViewEvent implements IEvent {

    protected final Object eventSource;

    public ViewEvent() {
        eventSource = new Object();
    }

    public ViewEvent(Object eventSource) {
        this.eventSource = Objects.requireNonNull(eventSource);
    }

    @Override
    public Object getSource() {
        return eventSource;
    }
    
}
