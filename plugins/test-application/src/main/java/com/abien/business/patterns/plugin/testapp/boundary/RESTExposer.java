package com.abien.business.patterns.plugin.testapp.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
@Path("plugins")
@Produces(MediaType.TEXT_PLAIN)
public class RESTExposer {

    @Inject
    Plugins tester;
    
    @GET
    public String modules(){
        return tester.discoverPlugins();
    }
    
}
