/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgreo.testRunner;

import com.grego.vgrep.app.launcher.ILaunchable;
import javafx.application.Platform;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Grigorios
 */
public class JavaFXJUnit4ClassRunner extends BlockJUnit4ClassRunner {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JavaFXJUnit4ClassRunner.class);

    public JavaFXJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
        
        final ILaunchable testApp = new JavaFxTestApplication();
        testApp.invokeLauncher(new String[0]);
    }

    //Code from: http://awhite.blogspot.gr/2013/04/javafx-junit-testing.html
    @Override
    protected void runChild(final FrameworkMethod method, final RunNotifier notifier) {
        // Create a latch which is removed after the super runChild() method completion
        final CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            // Call super to actually do the work
            super.runChild(method, notifier);
            // Decrement the latch which will now proceed.
            latch.countDown();
        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            LOGGER.warn(ex.getMessage());
        }
    }

}
