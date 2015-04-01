package de.oop.etrade.business.ordering.boundary;

import de.oop.etrade.business.ordering.control.Connect;
import de.oop.etrade.business.ordering.control.Exchange;
import de.oop.etrade.business.ordering.control.FXConnect;
import de.oop.etrade.business.ordering.entity.Stock;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.ApplicationException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("stocks")
@Stateless
@Interceptors(APIAudit.class)
public class QuoteService {

    @PersistenceContext
    EntityManager em;

    @Inject 
    Instance<Connect> fx;

    @Inject
    Event<Stock> stockNotifier;

    @Resource
    SessionContext sc;


    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @RolesAllowed("hugo")
    public Stock findStock(){
        for (Connect connect : fx) {
            System.out.println("---Found implementation: " + connect);
        }
        Stock stock = new Stock("sunw", 42);
        stockNotifier.fire(stock);
        return stock;
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response updateQuote(Stock quote){
        em.persist(quote);
        System.out.println("------- " + quote);
        return Response.ok().build();
    }

    public float getQuote() {
        return 42;
    }
}
