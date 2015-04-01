package com.javaone.coolparts.two;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class ControlFactory {
    
    @Produces
    public Control create(){
        return new Control("Created control --- ");
    }
    
}
