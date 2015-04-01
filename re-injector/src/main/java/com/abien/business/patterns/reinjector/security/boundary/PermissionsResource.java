package com.abien.business.patterns.reinjector.security.boundary;

import com.abien.business.patterns.reinjector.security.entity.Permission;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Path("permissions")
@Stateless
@Produces(MediaType.APPLICATION_XML)
public class PermissionsResource {
    
    @Inject
    Instance<Permission> lazyPermission;

    @Inject
    Permission permission;
    
    @GET
    public Permission get(){
        return permission;
    }

    @GET 
    @Path("lazy")
    public Permission lazyGet(){
        return lazyPermission.get();
    }
}
