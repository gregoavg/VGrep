/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control.loader;

import com.grego.vgrep.event.ICallback;
import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b>Asynchronous</b> implementation of <code>IContentLoader</code> interface.
 * This implementation makes use of callback events in order to inform and provide
 * clients with the contents of file that emerged after the load process. 
 * 
 * @author Grego
 */
public final class AsyncContentLoader implements IContentLoader {
    
    //thread management service
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private ICallback<IFileContent> callback = (data) -> {
        //empty callback
    };

    @Override
    public void setCallback(ICallback<IFileContent> callback) {
        this.callback = Objects.requireNonNull(callback, "Callback must not be null!");
    }

    @Override
    public void loadFrom(ADataFile file) {
        executor.execute(() -> {
            final IFileContent content = file.getContent();
            callback.onReturn(content);
        });
    }

}
