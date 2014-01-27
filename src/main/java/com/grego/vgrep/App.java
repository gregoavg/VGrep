package com.grego.vgrep;

import com.grego.vgrep.gui.MainFormUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * main class
 *
 */
public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        LOGGER.info("Application started");
        new MainFormUI().setVisible(true);
    }
}
