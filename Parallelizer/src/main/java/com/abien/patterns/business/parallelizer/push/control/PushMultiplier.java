package com.abien.patterns.business.parallelizer.push.control;

import com.abien.patterns.business.parallelizer.push.ComputationResults;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PushMultiplier {

    @Inject @ComputationResults
    Event<Long> results;
    
    @Inject
    Event<MultiplicationParameters> failureListener;
    
    @Resource
    SessionContext sc;
    
    @Asynchronous
    public void multiply(long a,long b){
        multiply(new MultiplicationParameters(a, b));
    }
    
    @Asynchronous
    public void multiply(MultiplicationParameters parameters){
        if(parameters.getAndSetProcessed()){
            System.out.println("Rejecting already processed parameter: " + parameters);
            return;
        }
        failureListener.fire(parameters);
        long a = parameters.getA();
        long b = parameters.getB();
        long c;
        try {
            System.out.println("--before " + a + "*" + b);
            Thread.sleep(2000);
            c = a*b;
            System.out.println("--after " + a + "*" + b);
            results.fire(c);
            sc.setRollbackOnly();
        } catch (InterruptedException ex) {}
    }
}
