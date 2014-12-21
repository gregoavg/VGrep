/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgreo.testRunner;

import com.grego.vgrep.app.launcher.ILaunchable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Grigorios
 */
public class JavaFxTestApplication extends Application implements ILaunchable {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("JavaFX Runtime initialized!!");
    }

    @Override
    public void trigLauncher(String[] args) {
        // start the JavaFX application
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            Application.launch();
        });
        
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(JavaFxTestApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
