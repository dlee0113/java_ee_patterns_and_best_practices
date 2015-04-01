package de.jax.erw.business.wedding.control;

import de.jax.erw.business.wedding.entity.WedLock;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SkyPilot {
    
    private boolean bias;

    public SkyPilot(boolean bias) {
        this.bias = bias;
    }
    
    
    public boolean validate(WedLock lock){
        //throw new IllegalStateException("Deadlock in wedlock"); 
        return bias;
    }
}
