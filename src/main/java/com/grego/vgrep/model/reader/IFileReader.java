/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader;

import com.grego.vgrep.model.data.ADataFile;
import com.grego.vgrep.model.data.IFileContent;

/**
 *
 * @author Grigorios
 */
public interface IFileReader {

    IFileContent read(final ADataFile dataFile);

}
