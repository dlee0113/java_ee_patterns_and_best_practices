/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author abien
 */
//@Path("brewery")
public class BreweriesResource {
    
    private String name;

    public BreweriesResource(String name) {
        this.name = name;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Brewery brewery(){
        return new Brewery("Pride " + name);
    }

    
}
