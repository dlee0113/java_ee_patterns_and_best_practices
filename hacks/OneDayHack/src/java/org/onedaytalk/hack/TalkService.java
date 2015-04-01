package org.onedaytalk.hack;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.onedaytalk.hack.configuration.LegacyPOJO;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class TalkService {
    @Inject 
    private String message;
    
    @Inject
    private LegacyPOJO lpojo;
    
    public String hello(){
       return message + this.lpojo.getMessage();
    }
}
