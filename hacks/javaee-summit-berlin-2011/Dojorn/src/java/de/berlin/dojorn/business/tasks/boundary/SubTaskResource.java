package de.berlin.dojorn.business.tasks.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SubTaskResource {
    
    private String name;

    public SubTaskResource(String name) {
        this.name = name;
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return this.name;
    }
    
}
