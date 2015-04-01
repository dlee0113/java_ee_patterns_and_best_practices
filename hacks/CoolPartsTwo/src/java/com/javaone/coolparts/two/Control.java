package com.javaone.coolparts.two;

import javax.annotation.PostConstruct;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Control {
    
    private String message;

    public Control(String message) {
        this.message = message;
    }
    
    
    
    @PostConstruct
    public void initialize(){
        System.out.println("Initializing control");
    }
    
    public String convertObjectToMap(String object){
        return message + object;
    }
    
}
