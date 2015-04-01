package com.abien.business.patterns.reinjector.em.boundary;

import com.abien.business.patterns.reinjector.em.entity.ConfigurationEntry;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Path("configuration")
@Stateless
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ConfigurationResource {
    
    @Inject
    ConfigurationService cs;
    
    
    @GET
    public List<ConfigurationEntry> get(){
        return cs.getConfiguration();
    }

    @GET
    @Path("{id}")
    public ConfigurationEntry get(@PathParam("id") String id){
        return cs.getEntry(id);
    }
    
    @PUT
    public void save(ConfigurationEntry ce){
        cs.saveOrUpdate(ce);
    }
            
}
