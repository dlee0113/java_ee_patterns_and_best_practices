package com.abien.injection.cdi;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("injection")
@Stateless
public class Boundary {

    @Inject
    ControlWithEMResourceDIGlobalJNDI control;

    @Inject
    ControlWithDataSourceDI datasourceControl;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(PersistentEntity entity){
        this.control.save(entity);
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersistentEntity find(@PathParam("id") long id){
        PersistentEntity entity = this.control.find(id);
        if(entity == null){
            entity = new PersistentEntity("duke");
        }
        return entity;

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkDB(){
        return datasourceControl.getConnectionAsString();
    }
}
