package com.javaone.coolparts;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class LegacyConnector {
    
    
    @Produces
    public SadLegacy connect(){
        return new SadLegacy(" I'm a factory! ");
    }
    
}
