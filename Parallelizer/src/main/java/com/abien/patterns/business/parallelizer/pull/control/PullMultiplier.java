package com.abien.patterns.business.parallelizer.pull.control;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PullMultiplier {
    
    @Asynchronous
    public Future<Long> multiply(long a,long b){
        long c=0;
        try {
            System.out.println("--before " + a + "*" + b);
            Thread.sleep(2000);
            c = a*b;
            System.out.println("--after " + a + "*" + b);
        } catch (InterruptedException ex) {}
        return new AsyncResult<>(c);
    }
}
