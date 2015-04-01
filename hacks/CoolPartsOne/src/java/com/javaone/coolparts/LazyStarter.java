package com.javaone.coolparts;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@Singleton
public class LazyStarter {
    
    
    @PostConstruct
    public void start(){
        System.out.println("Lazy Starting!");
    }
}
