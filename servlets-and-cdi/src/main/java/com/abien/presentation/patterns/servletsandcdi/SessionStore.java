package com.abien.presentation.patterns.servletsandcdi;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author adam-bien.com
 */
@SessionScoped
public class SessionStore implements Serializable{
    
    public static AtomicLong INSTANCE_COUNT = new AtomicLong(0);
    
    private String payload;
    
    @PostConstruct
    public void onNewSession(){
        INSTANCE_COUNT.incrementAndGet();
    }

    public String getPayload() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SessionStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @PreDestroy
    public void onSessionDestruction(){
        INSTANCE_COUNT.decrementAndGet();
    }
    
}
