/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abien
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Brewery {
    
    private String name;

    public Brewery() {
    }

    public Brewery(String name) {
        this.name = name;
    }
    
    
    
}
