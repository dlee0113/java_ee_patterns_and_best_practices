/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import java.awt.PageAttributes;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author abien
 */
@Stateless
@Path("beers")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class BeersResource {
    
    @Context
    HttpServletRequest hsr;
    
    @Inject
    IPSniffer sniff;

    @javax.enterprise.inject.Produces
    public int ip() {
        return hsr.getLocalPort();
    }
    
    
    
    @GET
    public Bottle beers(){
        sniff.sniff();
        return new Bottle("bud", 42);
    }
    
    @Path("/brewery")
    public BreweriesResource brewery(@Context HttpHeaders headers){
        return new BreweriesResource("bud " + headers);     
    }
    
    @PUT
    public Response save(Bottle bottle){
        System.out.println("Consumed!: " + bottle);
        return Response.ok().build();
    }
}
