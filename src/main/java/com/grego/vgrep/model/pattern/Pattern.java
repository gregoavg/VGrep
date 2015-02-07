package com.grego.vgrep.model.pattern;

import java.util.Objects;

/**
 *
 * @author Grigorios
 */
public class Pattern {

    private final String text;

    public Pattern(String text) {
        Objects.requireNonNull(text,"Word pattern can't be null");
        this.text = text;
    }


    public String getText() {
        return text;
    }

}
