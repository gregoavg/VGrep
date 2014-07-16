/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.control;

import com.grego.vgrep.model.data.IFileManager;
import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.SimpleReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Grigorios
 */
public final class ReferenceCreator {

    private final Set<IReference> referenceSet = new HashSet<>();
    
    public ReferenceCreator(IFileManager fileManager) {
        
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
                        IReference ref = new SimpleReference(info, target);
                        referenceSet.add(ref);
                    }
                }
            }
        }
    }
    
    public Set<IReference> getReferences() {
        return referenceSet;
    }
    

}
