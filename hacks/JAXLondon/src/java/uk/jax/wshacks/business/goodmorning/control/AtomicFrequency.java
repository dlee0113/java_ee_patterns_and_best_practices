/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

/**
 *
 * @author abien
 */
public class AtomicFrequency {
    private int frequency;

    public AtomicFrequency(int frequency) {
        this.frequency = frequency;
    }

    
    public long frequency(){
        return frequency;
    }
    
}
