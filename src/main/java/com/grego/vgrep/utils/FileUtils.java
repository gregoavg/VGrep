/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import com.grego.vgrep.model.reader.parseStrategy.EFileType;
import com.grego.viewmanager.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.UnknownFormatFlagsException;

/**
 *
 * @author grigo_000
 */
public final class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    public static EFileType getFileType(File file) throws UnknownFormatFlagsException {
        String fileName = file.getName().toLowerCase();
        String fileType = CollectionUtils.getLastElement(Arrays.asList(fileName.split("\\.")));

        switch (fileType)
        {
            case "pdf":
                return EFileType.PDF;
            case "xls":
                return EFileType.XLS;
            case "txt":
                return EFileType.TXT;
            case "doc":
                return EFileType.DOC;
            default:
                return EFileType.OTHER;
        }
    }

}
