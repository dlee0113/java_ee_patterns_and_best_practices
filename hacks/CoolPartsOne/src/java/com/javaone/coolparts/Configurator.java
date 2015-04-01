package com.javaone.coolparts;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Configurator {
    
    
    @Produces
    public String configure(InjectionPoint ip){
        String clazz = ip.getMember().getDeclaringClass().getName();
        String name = ip.getMember().getName();
        
        return "42 " + clazz + "." + name;
    }
    
}
