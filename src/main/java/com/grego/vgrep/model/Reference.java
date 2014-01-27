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
public class Reference implements IReference {

    private final String info;
    private final String target;

    public Reference(String info, String target) {
        this.info = info;
        this.target = target;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public String getReferencedLine() {
        return "Info: " + this.info + " Target: " + this.target;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.info);
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
        final Reference other = (Reference) obj;
        if (!Objects.equals(this.info, other.info))
        {
            return false;
        }
        return Objects.equals(this.target, other.target);
    }

}
