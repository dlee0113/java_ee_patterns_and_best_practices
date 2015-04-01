package com.abien.patterns.business.parallelizer.push.control;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class FailureListener {
    
    @Inject
    PushMultiplier multiplier;

    public void onFailedComputation(@Observes(during=TransactionPhase.AFTER_FAILURE) MultiplicationParameters parameters){
        System.out.println("!!! re-attempting");
        multiplier.multiply(parameters);
    }
}
