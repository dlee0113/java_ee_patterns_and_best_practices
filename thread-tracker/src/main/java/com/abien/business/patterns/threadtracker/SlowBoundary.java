package com.abien.business.patterns.threadtracker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Bien, adam-bien.com
 */
public class SlowBoundary {
    
    public String getMessageSlowly(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlowBoundary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "very slow";
    }
}
