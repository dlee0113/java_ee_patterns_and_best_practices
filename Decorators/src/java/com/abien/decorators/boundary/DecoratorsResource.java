package com.abien.decorators.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Path("decorators")
@Stateless
@Produces(MediaType.TEXT_PLAIN)
public class DecoratorsResource {
    
    @Inject
    private Messenger messenger;
    
    @GET
    public String hey(){
        return messenger.morning();
    }
    
}
