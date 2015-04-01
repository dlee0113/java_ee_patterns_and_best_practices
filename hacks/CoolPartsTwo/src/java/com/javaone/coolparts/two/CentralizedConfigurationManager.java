package com.javaone.coolparts.two;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Singleton
@Startup
public class CentralizedConfigurationManager {
    
    @Inject
    Instance<ConfigurationProvider> cp;
    
    
    @PostConstruct
    public void preConfigure(){
        for (ConfigurationProvider configurationProvider : cp) {
            System.out.println("---- " + configurationProvider.getConfiguration());
        }
    }
    
    
    @Produces
    public int getConfig(InjectionPoint ip){
        String clazz = ip.getMember().getDeclaringClass().getName();
        System.out.println("--- got configuration: ");
        String name = ip.getMember().getName();
        System.out.println("--- configuring: " + clazz + "." +name);
                
        return 21;
    
    }
    
}
