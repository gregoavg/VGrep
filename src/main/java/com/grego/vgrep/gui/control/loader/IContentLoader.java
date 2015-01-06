/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control.loader;

import com.grego.vgrep.event.ICallable;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;

/**
 * Representer for instances responsible to load contents from files.
 * This interface extends and makes use of callable interface, in order to
 * update loader into callback caller. As callback caller, loader can provide
 * the emerged content to clients, by invoking the referenced callback method.
 * 
 * @author Grego
 */
public interface IContentLoader extends ICallable<IFileContent> {

    /**
     * Loads content from a given <code>ADataFile</code> instance.
     * 
     * @param file 
     * @see   ADataFile
     * 
     */
    void loadFrom(ADataFile file);
    
}
