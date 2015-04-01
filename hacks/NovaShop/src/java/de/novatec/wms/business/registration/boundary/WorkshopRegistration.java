package de.novatec.wms.business.registration.boundary;

import de.novatec.wms.business.registration.entity.Workshop;
import java.net.URI;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Interceptors(LoggingInterceptor.class)
@Path("registrations")
@Stateless
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class WorkshopRegistration {

    @Inject
    private int maxNumberOfRegistrations;

    @PersistenceContext //(unitName="NovaShopPU")
    EntityManager em;

    @Inject
    Event<Workshop> registrationService;

    @Resource
    SessionContext sc;



    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Workshop getAllRegistrations(){
        return new Workshop("bald pause",99);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Workshop byId(@PathParam("id") int id){
        return new Workshop("withId", id);
    }



    public Date getDate(){
        return new Date();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response register(Workshop workshop) {
        em.persist(workshop);
        registrationService.fire(workshop);
        URI create = URI.create(String.valueOf(workshop.getId()));
        sc.setRollbackOnly();
        return Response.created(create).build();

    }

}
