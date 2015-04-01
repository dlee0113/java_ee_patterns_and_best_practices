package com.abien.patterns.business.parallelizer.push.control;

import com.abien.patterns.business.parallelizer.push.ComputationResults;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author adam bien, adam-bien.com
 */

public class ResultListener {

    public void onNewComputation(@Observes(during= TransactionPhase.AFTER_SUCCESS) @ComputationResults Long result){
        System.out.println("=Push= " + result);
    }

    public void onFailedComputation(@Observes(during= TransactionPhase.AFTER_FAILURE) @ComputationResults Long result){
        System.out.println("!!!Push!!!! " + result);
    }
}
