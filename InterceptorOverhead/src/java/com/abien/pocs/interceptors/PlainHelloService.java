package com.abien.pocs.interceptors;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Path("plain")
@Stateless
@Produces(MediaType.TEXT_PLAIN)
public class PlainHelloService {
    @GET
    public String call(){
        return System.currentTimeMillis() + " ";
    }
    
}
