/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

import com.grego.vgrep.model.pattern.Pattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class FindReferencesEvent extends ViewEvent {
    
    private List<Pattern> patterns;

    public FindReferencesEvent() {
        super();
        patterns = new ArrayList<>();
    }

    public FindReferencesEvent(List<Pattern> patterns) {
        super();
        this.patterns = patterns;
    }
    
    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }
}
