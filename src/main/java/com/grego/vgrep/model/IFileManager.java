/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

import java.io.File;

/**
 *
 * @author grigo_000
 */
public interface IFileManager {

    IFileHolder getInfoFileHolder();

    IFileHolder getTargetFileHolder();

    void removeFiles();

    void setInfoFile(File infoFile);

    void setTargetFile(File targerFile);
    
}
