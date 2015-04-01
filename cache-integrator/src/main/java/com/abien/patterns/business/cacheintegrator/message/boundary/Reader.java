package com.abien.patterns.business.cacheintegrator.message.boundary;

import com.abien.patterns.business.cacheintegrator.caching.control.Cache;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
@Path("messages")
@Produces(MediaType.TEXT_PLAIN)
public class Reader {
    
    @Inject @Cache
    ConcurrentMap<String, Object> cache;
    
    @GET
    public String messages(){
        return cache.toString();
    }
}
