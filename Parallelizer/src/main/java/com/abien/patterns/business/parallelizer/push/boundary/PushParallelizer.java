package com.abien.patterns.business.parallelizer.push.boundary;

import com.abien.patterns.business.parallelizer.push.control.PushMultiplier;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PushParallelizer {
    
    @Inject
    PushMultiplier asyncWorker;
    
    public void executeInParallel(int iterations) {
        for (int i = 0; i < iterations; i++) {
            asyncWorker.multiply(i, i);
        }
    }
    
}
