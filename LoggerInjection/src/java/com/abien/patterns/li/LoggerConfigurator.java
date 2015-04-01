package com.abien.patterns.li;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class LoggerConfigurator {
    
    @Produces
    public Logger get(InjectionPoint ip){
        Class<?> requestingClass = ip.getMember().getDeclaringClass();
        System.out.println("Logger created for: " + requestingClass.getName());
        return Logger.getLogger(requestingClass.getName());
    }
}
