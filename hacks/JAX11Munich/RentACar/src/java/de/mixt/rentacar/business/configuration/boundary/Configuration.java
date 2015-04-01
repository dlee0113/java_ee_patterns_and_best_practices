/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.configuration.boundary;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Configuration {

    @Inject
    Instance<ConfigurationSource> cs;
    
    @PostConstruct
    public void loadConfig() {
        for (ConfigurationSource configurationSource : cs) {
            System.out.println("---Found resource: " + configurationSource);
            Map<String, String> configuration = configurationSource.getConfiguration();
        }
        
        

        System.out.println("Load configuration!");
    }

    @Produces
    public String getString(InjectionPoint ip) {
        Class<?> clazz = ip.getMember().getDeclaringClass();
        String fieldName = ip.getMember().getName();
        return clazz.getName() + "." + fieldName;
    }
}
