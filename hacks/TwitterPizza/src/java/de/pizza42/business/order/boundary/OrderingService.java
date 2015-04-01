package de.pizza42.business.order.boundary;

import de.pizza42.business.order.control.CourierService;
import de.pizza42.business.order.entity.Pizza;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pizzas")
@Stateless
@Interceptors(Audits.class)
public class OrderingService {

    @Inject
    CourierService cs;

    @Resource
    SessionContext sc;

    @Inject @Quality(Quality.Level.GUM)
    Event<String> pizzaNotification;

    @PersistenceContext
    EntityManager em;

    @Inject
    Instance<PackagingService> service;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Pizza fromBusinessLogic(){
        cs.deliver("Cappriciosa");
        pizzaNotification.fire("Pizza ist da!");
        Pizza pizza = new Pizza("duke", 42);
        em.persist(pizza);
        return pizza;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response order(Pizza pizza){
        for (PackagingService packagingService : service) {
            System.out.println("Found: " + packagingService);
        }
        System.out.println("Pizza: " + pizza);
        return Response.ok().build();
    }
}
