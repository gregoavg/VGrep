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
public enum ApplicationLauncher implements ILauncher {

    INSTANCE;

    private String[] launchArgs;

    @Override
    public String[] getLaunchArgs() {
        return launchArgs;
    }

    @Override
    public void setLaunchArgs(String[] launchArgs) {
        this.launchArgs = launchArgs;
    }

    @Override
    public void trigLaunch(ILaunchable application) {
        application.setLauncher(this);
        application.launch();
    }

    @Override
    public void onLaunchCompleted() {
        //not implemented
    }

}
