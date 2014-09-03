/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import com.grego.vgrep.model.data.EDataType;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import static com.grego.vgrep.model.data.EDataType.SOURCE;
import static com.grego.vgrep.model.data.EDataType.TARGET;

/**
 *
 * @author grigo_000
 */
public class SimpleReference implements IReference<String,String> {

    private final Map<EDataType, String> refMapper = new EnumMap<>(EDataType.class);

    public SimpleReference(String source, String target) {
        refMapper.put(SOURCE, source);
        refMapper.put(TARGET, target);
    }

    @Override
    public String getSource() {
        return refMapper.get(SOURCE);
    }

    @Override
    public String getTarget() {
        return refMapper.get(TARGET);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.refMapper);
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
        return Objects.equals(this.refMapper, other.refMapper);
    }
    
    

    @Override
    public String toString() {
        return "Source: " + refMapper.get(SOURCE) + ", Target: " + refMapper.get(TARGET);
    }
    
    

}
