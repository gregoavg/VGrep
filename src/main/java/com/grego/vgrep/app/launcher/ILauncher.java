/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.app.launcher;

/**
 *
 * @author Grigorios
 */
public interface ILauncher {
    
    String[] getLaunchArgs();
    
    void setLaunchArgs(String[] launchArgs);
    
    void trigLaunch(ILaunchable launchable);
    
    void onLaunchCompleted();
}
