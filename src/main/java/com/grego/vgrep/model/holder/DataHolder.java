/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.holder;

import com.grego.vgrep.model.data.AData;
import java.util.Objects;

/**
 *
 * @author grigo_000
 */
public final class DataHolder implements IHolder<AData> {

    private AData data;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.data);
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
        final DataHolder other = (DataHolder) obj;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public void hold(AData t) {
        data = t;
    }

    @Override
    public AData getHoldingItem() {
        return data;
    }

    @Override
    public void removeItem() {
        data = null;
    }

    @Override
    public boolean isHolding() {
        return data != null;
    }

}
