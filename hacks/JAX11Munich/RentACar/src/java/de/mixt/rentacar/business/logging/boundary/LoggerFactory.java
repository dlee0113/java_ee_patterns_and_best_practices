/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.logging.boundary;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class LoggerFactory {
    
    @Produces
    public Log log(InjectionPoint ip){
        return new Log(ip.getMember().getDeclaringClass());
    }
    
}
