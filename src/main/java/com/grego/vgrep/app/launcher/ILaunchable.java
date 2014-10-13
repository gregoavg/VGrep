/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.app.launcher;

import com.grego.vgrep.app.launcher.ILauncher;

/**
 *
 * @author Grigorios
 */
public interface ILaunchable {

    void launch();

    void setLauncher(ILauncher launcher);

    void fireLaunchCompleted();
}
