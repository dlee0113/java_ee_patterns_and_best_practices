package com.abien.business.patterns.threadtracker;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    SlowBoundary sb;
    
    public String getMessage(){
        return sb.getMessageSlowly();
    }
}
