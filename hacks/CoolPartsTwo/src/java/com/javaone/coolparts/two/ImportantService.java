package com.javaone.coolparts.two;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@Singleton
public class ImportantService {
    
    
    @PostConstruct
    public void alsoStarting(){
        System.out.println("Have to start first!");
    }
}
