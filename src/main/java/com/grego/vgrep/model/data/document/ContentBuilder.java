/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grego.vgrep.model.data.document;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grego
 */
public final class ContentBuilder {
    
    private final List<Line> lines = new ArrayList<>();
    
    public void appendLine(String text) {
        lines.add(new Line(text));
    }
    
    public DocumentContents getContents() {
        return new DocumentContents(lines);
    }
}
