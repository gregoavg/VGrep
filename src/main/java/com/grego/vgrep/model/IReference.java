/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grego.vgrep.model;

/**
 *
 * @author grigo_000
 */
public interface IReference {

    String getTarget();

    String getInfo();
    
    String getReferencedLine();
}
