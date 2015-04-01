package de.duke.mugs.business.order;

import de.duke.mugs.business.order.control.Question;
import de.duke.mugs.business.order.entity.DukeMug;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

@Interceptors(SLAAudit.class)
@Stateless
@Path("mugs")
public class DukeMugOrderingService {


    @Inject @Question(Question.Quality.BAD)
    Event<DukeMug> events;

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public DukeMug helloDuke(){
        return new DukeMug("Rockstar ",true);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response save(DukeMug dukeMug){
        em.persist(dukeMug);
        events.fire(dukeMug);
        System.out.println("Got duke: " + dukeMug);
        return Response.ok().build();
    }

}
