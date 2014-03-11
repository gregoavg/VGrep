/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.utils;

import com.grego.vgrep.control.EFileType;
import java.io.File;
import java.util.UnknownFormatFlagsException;

/**
 *
 * @author grigo_000
 */
public final class FileUtils {

    public static EFileType getFileType(File file) throws UnknownFormatFlagsException {
        String fileName = file.getName().toLowerCase();
        int beginIndex = fileName.lastIndexOf(".") + 1;
        String fileType = fileName.substring(beginIndex).trim();

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
                throw new UnknownFormatFlagsException("Unsupported file type exception!");
        }
    }
}
