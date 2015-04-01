package de.jax.erw.business.wedding.boundary;

import de.jax.erw.business.wedding.control.SkyPilot;
import de.jax.erw.business.wedding.entity.WedLock;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
@Interceptors(Journalist.class)
public class RoyalWeddingService {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<WedLock> wedlockSink;
    
    @Inject
    SkyPilot pilot;
   
    @Resource
    SessionContext sc;
    
    
    public void performWedLock(WedLock lock){
        this.em.persist(lock);
        wedlockSink.fire(lock);
        if(!pilot.validate(lock))
            throw new IllegalStateException("SkyPilot cancelled wedlock!");
    }
    
    public String getMessage(){
        //throw new IllegalStateException("Go away!");
        return "I love you";
    }
}
