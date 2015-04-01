package com.abien.patterns.business.txtracking;

import com.abien.patterns.business.txtracking.boundary.TXTracker;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    TXTracker txt;
    
    public Object commit(){
        txt.success();
        return null;
    }

    public Object failureBeforeCompletion(){
        txt.failureInBeforeCompletion();
        return null;
    }
    
    public Object rollback(){
        txt.failure();
        return null;
    }
}
