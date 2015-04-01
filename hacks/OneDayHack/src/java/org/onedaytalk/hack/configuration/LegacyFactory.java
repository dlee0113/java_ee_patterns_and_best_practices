package org.onedaytalk.hack.configuration;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class LegacyFactory {
 
    
    @Produces
    public LegacyPOJO create(String message){
        return new LegacyPOJO(message);
    }
}
