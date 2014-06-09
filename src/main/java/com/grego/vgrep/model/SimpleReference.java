/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import java.util.Objects;

/**
 *
 * @author grigo_000
 */
public class SimpleReference implements IReference<String,String> {

    private final String source;
    private final String target;

    public SimpleReference(String info, String target) {
        this.source = info;
        this.target = target;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public String getReferencedLine() {
        return "Info: " + this.source + " Target: " + this.target;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.source);
        hash = 13 * hash + Objects.hashCode(this.target);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final SimpleReference other = (SimpleReference) obj;
        if (!Objects.equals(this.source, other.source))
        {
            return false;
        }
        return Objects.equals(this.target, other.target);
    }

}
