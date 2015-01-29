/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.event;

import com.grego.vgrep.model.holder.IHolder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grigorios
 */
public final class FindReferencesEvent extends ViewEvent {
    
    private List<IHolder> patterns;

    public FindReferencesEvent() {
        super();
        patterns = new ArrayList<>();
    }

    public FindReferencesEvent(List<IHolder> patterns) {
        super();
        this.patterns = patterns;
    }
    
    public List<IHolder> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<IHolder> patterns) {
        this.patterns = patterns;
    }
}
