/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.app.launcher;

/**
 * Adapter for operations that need to be invoked in order to
 * initialize or start their behavior
 * 
 * @author Grigorios
 */
public interface ILaunchable {

    /**
     * Invokes launcher with arguments
     * 
     * @param args the command arguments
     * 
     */
    void invokeLauncher(String[] args);
    
}
