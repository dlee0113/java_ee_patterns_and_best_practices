/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author abien
 */
public class Configurator {
        
    @Produces
    public String getString(InjectionPoint ip){
        return "Corona " + ip.getMember().getName();
    }
}
