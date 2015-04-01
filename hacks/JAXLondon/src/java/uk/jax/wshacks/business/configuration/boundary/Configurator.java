/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.configuration.boundary;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author abien
 */
public class Configurator {
    
    @Inject
    Instance<ConfigurationReader> cr;
    
    @PostConstruct
    public void searchForPlugins(){
        for (ConfigurationReader configurationReader : cr) {
            System.out.println("-Plugin-- " + configurationReader);
        }
    }

    @Produces
    public int getNumber(InjectionPoint ip){
        Class<?> clazz = ip.getMember().getDeclaringClass();
        String name = ip.getMember().getName();
        System.out.println(clazz.getName() + "." + name);
        return 42;
    }
}
