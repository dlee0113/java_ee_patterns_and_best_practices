package com.abien.patterns.business.aspects.cache.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 *
 * @author adam bien, adam-bien.com
 */
@ApplicationScoped
public class TestChangeListener {
    private String message;
    
    public void onNotification(@Observes String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    
}
