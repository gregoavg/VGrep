/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

import com.grego.vgrep.model.data.ADataFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class FindReferencesEvent extends ViewEvent {
    
    private List<String> patterns = null;

    public FindReferencesEvent(ADataFile eventSource) {
        super(eventSource);
        patterns = new ArrayList<>();
    }

    public FindReferencesEvent() {
        super();
        patterns = new ArrayList<>();
    }

    public FindReferencesEvent(List<String> patterns) {
        super();
        this.patterns = patterns;
    }
    
    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }
}
