package com.vegas.casino.business;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("casino")
@Interceptors(CasinoManager.class)
@Stateless
public class Casino {

    @Inject
    IBandit bandit;

    @Inject @Money(Money.Amount.LOT)
    Event<String> accidentListener;

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Loot getGame(){
        bandit.stealSomething();
        accidentListener.fire("Stolen!");
        final Loot loot = new Loot(42);
        em.persist(loot);
        return loot;
    }

}
