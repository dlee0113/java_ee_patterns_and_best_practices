package com.javaone.coolparts;

import javax.enterprise.event.Observes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class UnCoolListener {
    
    public void sorryForThat(@Observes @Coolness(Coolness.Factor.NOT_COOL) String message){
        System.out.println("--- "+ message);
    }
}
