package com.abien.patterns.threading.longpolling;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Path("events")
@Stateless
public class EventsResource {
    
    @Inject
    Event<String> event;
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void fire(String message){
        event.fire(message);
    }
}
