package de.javaeesummit.hotel.boundary;

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
@Path("registrations")
@Produces(MediaType.TEXT_PLAIN)
@Stateless
public class RegistrationsResource {
    
    @Inject
    RegistrationService registrationService;
    
    @GET
    public String registrations(){
        return "42 " + registrationService.registered();
    }
}
