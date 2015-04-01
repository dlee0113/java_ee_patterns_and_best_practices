package ro.dracula.business.order.boundary;

import java.util.List;
import javax.ejb.EJB;
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
import ro.dracula.business.order.control.DrinkingLevel;
import ro.dracula.business.order.control.IngredientsProvider;
import ro.dracula.business.order.control.PalincaCreationEngine;
import ro.dracula.business.order.control.PalincaDeliveryService;
import ro.dracula.business.order.entity.FireFluid;

@Path("orders")
@Interceptors(PrivateDistilleryWatchingDepartment.class)
@Stateless
public class PalincaComanderService {

    @PersistenceContext
    EntityManager em;

    @Inject
    PalincaCreationEngine pce;

    @EJB
    PalincaDeliveryService pds;

    @Inject
    Event<FireFluid> deliveryNotification;

    @Inject 
    Instance<IngredientsProvider> ip;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public FireFluid hello(){
        return new FireFluid("hey palinca");
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response order(FireFluid fluid){
        em.persist(fluid);
        return Response.ok().build();
    }

    public List<FireFluid> all(String name){
        return em.createNamedQuery("findall").setParameter("name", name + "%").getResultList();
    }

    public String order(int liter){
        final FireFluid fireFluid = new FireFluid("palinca");
        em.persist(fireFluid);
        pds.deliver();
        deliveryNotification.fire(fireFluid);
        for (IngredientsProvider ingredientsProvider : ip) {
            System.out.println("Found: " + ingredientsProvider);

        }
        return "Ordered: " + liter + " Burned " + pce.burn();
    }

}
