/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.control;

import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.Reference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Grigorios
 */
public final class ReferenceBuilder {
    
    private final Set<IReference> referenceSet = new HashSet<IReference>();
    
    public ReferenceBuilder(Collection<String> infoCollection, Collection<String> targetCollection) {
        constructReferences(infoCollection, targetCollection);
    }
    
    public Set<IReference> getReferences() {
        return referenceSet;
    }
    
    private void constructReferences(Collection<String> infoCollection, Collection<String> targetCollection) {
        
        for (String info : infoCollection)
        {
            String[] infoLineValues = info.split(" ");
            for (String regEx : infoLineValues)
            {
                for (String target : targetCollection)
                {
                    if (target.contains(regEx))
                    {
                        IReference ref = new Reference(info, target);
                        referenceSet.add(ref);
                    }
                }
            }
        }
    }

}
