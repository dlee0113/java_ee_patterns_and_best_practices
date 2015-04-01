package com.abien.patterns.business.asyncworker;

import com.abien.patterns.business.asyncworker.boundary.SlowService;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    SlowService service;
    
    public String getResult(){
        return service.invoke();
    }
    
    public String selfInvocation(){
        service.selfInvocation();
        return "self-invoked!";
    }
}
