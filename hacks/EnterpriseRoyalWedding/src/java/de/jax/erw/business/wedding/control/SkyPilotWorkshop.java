package de.jax.erw.business.wedding.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SkyPilotWorkshop {
    
    @Produces
    public SkyPilot create(){
        return new SkyPilot(true);
    }
}
