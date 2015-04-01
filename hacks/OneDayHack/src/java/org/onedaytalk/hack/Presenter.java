package org.onedaytalk.hack;

import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Presenter {
    
    @Inject
    TalkService service;
    
    public String hello(){
        return service.hello();
    }
    
}
