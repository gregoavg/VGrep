/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.gui.control.loader;

import com.grego.vgrep.model.file.ADataFile;
import com.grego.vgrep.model.file.IContent;
import com.grego.viewmanager.event.ICallback;

import javax.validation.constraints.NotNull;
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
public final class AsyncContentLoader implements ILoader<ADataFile, IContent> {
    
    //thread management service
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private ICallback<IContent> callback = ICallback.empty();

    @Override
    public void setCallback(@NotNull ICallback<IContent> callback) {
        this.callback = Objects.requireNonNull(callback, "Callback must not be null!");
    }

    @Override
    public void loadFrom(ADataFile file) {
        executor.execute(() -> {
            // first call to get file content actually loads the content.
            IContent content = file.getContent();
            callback.onCall(content);
        });
    }

}
