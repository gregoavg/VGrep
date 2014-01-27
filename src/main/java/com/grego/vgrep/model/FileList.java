/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author grigo_000
 */
public final class FileList implements IFileList {
    
    private final IFileHolder infoFileHolder;
    private final IFileHolder targetFileHolder;

    public FileList(IFileHolder infoFileHolder, IFileHolder targetFileHolder) {
        this.infoFileHolder = infoFileHolder;
        this.targetFileHolder = targetFileHolder;
    }

    public FileList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring.xml");
        this.infoFileHolder = (IFileHolder) ctx.getBean("IFileHolder");
        this.targetFileHolder = (IFileHolder) ctx.getBean("IFileHolder");
    }

    @Override
    public IFileHolder getInfoFileHolder() {
        return infoFileHolder;
    }

    @Override
    public IFileHolder getTargetFileHolder() {
        return targetFileHolder;
    }
    
    @Override
    public void setInfoFile(File infoFile) {
        this.infoFileHolder.setFile(infoFile);
    }

    @Override
    public void setTargetFile(File targerFile) {
        this.targetFileHolder.setFile(targerFile);
    }
    
    @Override
    public void removeFiles()
    {
        infoFileHolder.removeFile();
        targetFileHolder.removeFile();
    }
}
