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


public class AsyncContentLoader implements IContentLoader {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    
    private ICallback callBack = null;
    
    @Override
    public void setCallBack(ICallback callback) {
        this.callBack = Objects.requireNonNull(callback, "Callback must not be null!");
    }

    @Override
    public void loadFrom(ADataFile file) {
        Runnable loadFile = () -> {
            final IFileContent content = file.getContent();
            callBack.onReturn(content);
        };
        executor.execute(loadFile);
    }
    
}
