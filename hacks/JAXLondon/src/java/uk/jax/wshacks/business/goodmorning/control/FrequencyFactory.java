/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author abien
 */
public class FrequencyFactory {
    
    @Produces
    public AtomicFrequency create(){
        return new AtomicFrequency(42);
    }
}
