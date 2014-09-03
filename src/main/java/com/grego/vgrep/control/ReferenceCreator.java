/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.control;

import com.grego.vgrep.model.IReference;
import com.grego.vgrep.model.data.document.Line;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Grigorios
 */
public final class ReferenceCreator {

    private final Set<IReference> referenceSet = new HashSet<>();

    public Set<IReference> findReferences(Iterable source, Iterable target) {

        Iterator<Line> sourceIterator = source.iterator();
        while (sourceIterator.hasNext())
        {
            Line sourceLine = sourceIterator.next();

            /*.forEach((Line targetLine) -> {
             if (targetLine.compareTo(sourceLine) == Equal.integerValue()) {
             referenceSet.add(new SimpleReference(targetLine.toString(), sourceLine.toString()));
             }
             });*/
        }
        return null;
    }

    public Set<IReference> getReferences() {
        return referenceSet;
    }
}
