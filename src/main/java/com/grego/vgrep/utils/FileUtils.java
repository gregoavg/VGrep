/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import com.grego.vgrep.control.PersistanceType;
import java.io.File;
import java.util.UnknownFormatFlagsException;

/**
 *
 * @author grigo_000
 */
public final class FileUtils {

    public static PersistanceType getFileType(File file) throws UnknownFormatFlagsException {
        String fileName = file.getName().toLowerCase();
        int beginIndex = fileName.lastIndexOf(".") + 1;
        String fileType = fileName.substring(beginIndex).trim();

        switch (fileType)
        {
            case "pdf":
                return PersistanceType.PDF;
            case "xls":
                return PersistanceType.XLS;
            case "txt":
                return PersistanceType.TXT;
            case "doc":
                return PersistanceType.DOC;
            default:
                throw new UnknownFormatFlagsException("Unsupported file type exception!");
        }
    }
}
