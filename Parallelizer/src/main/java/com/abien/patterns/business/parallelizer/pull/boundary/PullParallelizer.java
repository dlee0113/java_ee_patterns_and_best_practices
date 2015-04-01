package com.abien.patterns.business.parallelizer.pull.boundary;

import com.abien.patterns.business.parallelizer.pull.control.PullMultiplier;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PullParallelizer {
    
    @Inject
    PullMultiplier asyncWorker;
    
    
    public List<Long> executeInParallel(int iterations) {
        List<Future<Long>> futures = new LinkedList<>();
        List<Long> results = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            futures.add(asyncWorker.multiply(i, i));
        }
        for (Future<Long> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException ex) {
                throw new EJBException("Problem during fetching a result",ex);
            }
        }
        return results;
    }
    
}
