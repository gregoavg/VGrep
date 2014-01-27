/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.control;

import com.grego.vgrep.model.IFileHolder;

import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author grigo_000
 */
public final class FileHolderBuilder {

    private IFileHolder fileHolder;

    public FileHolderBuilder(File file) {
        constructFileHolder(file);
    }

    public void constructFileHolder(File file) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring.xml");
        fileHolder = (IFileHolder) ctx.getBean("IFileHolder");
        fileHolder.setFile(file);
    }

    public IFileHolder getFileHolder() {
        return fileHolder;
    }

}
