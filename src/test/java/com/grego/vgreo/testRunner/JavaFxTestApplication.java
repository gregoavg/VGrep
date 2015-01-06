/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgreo.testRunner;

import com.grego.vgrep.app.launcher.ILaunchable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Grigorios
 */
public class JavaFxTestApplication extends Application implements ILaunchable {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JavaFxTestApplication.class);
    
    private static final CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.info("JavaFX Runtime initialized!!");
        latch.countDown();
    }

    @Override
    public void invokeLauncher(String[] args) {
        // start the JavaFX application thread
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            Application.launch(args);
        });
        // wait until JavaFX thread initialization completions
        try {
            latch.await();
        } catch (InterruptedException ex) {
            LOGGER.error(ex.getLocalizedMessage());
        }
    }

}
