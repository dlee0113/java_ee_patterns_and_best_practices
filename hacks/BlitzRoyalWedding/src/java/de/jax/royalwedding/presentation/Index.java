package de.jax.royalwedding.presentation;

import de.jax.royalwedding.business.wedlock.boundary.SkyPilot;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Model
public class Index {
    
    @EJB
    SkyPilot pilot;
    
    public String getMessage(){
        return pilot.getMessage();
    }
}
