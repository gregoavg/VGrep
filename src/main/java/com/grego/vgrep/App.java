package com.grego.vgrep;

import com.grego.vgrep.gui.ICompareView;
import com.grego.vgrep.gui.MainFormUI;
import com.grego.vgrep.gui.model.CompareModel;
import com.grego.vgrep.gui.presenter.ComparePresenter;
import com.grego.vgrep.gui.presenter.IComparePresenter;
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
        ICompareView view = new MainFormUI();
        IComparePresenter presenter = new ComparePresenter(new CompareModel());
        presenter.setView(view);
        
        view.setVisibility(true);
        LOGGER.info(" Application started");
    }
}
