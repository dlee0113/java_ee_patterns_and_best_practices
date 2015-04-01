package de.jax.royalwedding.business.wedlock.boundary;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class WeddingPlaner {
 
    
    @Produces
    public PrincipalWitness createWithYes(){
        return new PrincipalWitness(true);
    }
    
}
