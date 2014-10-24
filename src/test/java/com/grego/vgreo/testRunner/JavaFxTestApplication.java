/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgreo.testRunner;

import com.grego.vgrep.app.launcher.ILaunchable;
import com.grego.vgrep.app.launcher.ILauncher;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Grigorios
 */
public class JavaFxTestApplication extends Application implements ILaunchable {

    /**
     * Started flag.
     *
     * @throws java.lang.Exception
     */
    private static final AtomicBoolean hasStarted = new AtomicBoolean(false);
    private ILauncher launcher;

    @Override
    public void start(Stage primaryStage) throws Exception {
        hasStarted.set(Boolean.TRUE);
        System.out.println("JavaFX Runtime initialized!!");
    }

    @Override
    public void launch() {
        // start the JavaFX application
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            Application.launch(launcher.getLaunchArgs());
        });
        while (!hasStarted.get()) {
            Thread.yield();
        }
    }

    @Override
    public void setLauncher(ILauncher launcher) {
        this.launcher = launcher;
    }

    @Override
    public void fireLaunchCompleted() {
        launcher.onLaunchCompleted();
    }

}
