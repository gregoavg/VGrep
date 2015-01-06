/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model.reader.fileParser;

/**
 * Enumeration of types that this application can support. The <code>OTHER</code>
 * value was placed to inform reader, that there is no particular parse method for
 * that file. In that case, reader retrieves the default parse strategy.
 * 
 * @author grigo_000
 */
public enum EFileType {
    PDF,
    XLS,
    DOC,
    TXT,
    OTHER // as not supported file type.
}
