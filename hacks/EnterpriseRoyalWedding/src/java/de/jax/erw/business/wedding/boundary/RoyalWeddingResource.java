package de.jax.erw.business.wedding.boundary;

import de.jax.erw.business.wedding.entity.WedLock;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("weddings")
@Stateless
public class RoyalWeddingResource {
    
    
    @EJB
    RoyalWeddingService rws;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public WedLock getWedding(){
        return new WedLock("lucky", true);
    }
}
