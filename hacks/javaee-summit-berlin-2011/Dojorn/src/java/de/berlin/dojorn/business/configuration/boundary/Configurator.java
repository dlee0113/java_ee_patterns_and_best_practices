package de.berlin.dojorn.business.configuration.boundary;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Configurator {
    
    @Produces
    public String getString(InjectionPoint ip){
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        String name = ip.getMember().getName();
        return "configurable xmas" + declaringClass.getName() + "." + name;
    }
}
