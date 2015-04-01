/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author abien
 */
public class Clock {
    
    @Inject
    AtomicFrequency af;
    
    @Inject
    WakeUpTimeCalculator calculator;
    
    @PostConstruct
    public void onCreation(){
        System.out.println("--- Clock created " + af.frequency());
    }
 
    public Date time(){
        Future<Date> compute = calculator.compute();
        try {
            return compute.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
