
package de.twitterng.business.messaging.boundary;

import de.twitterng.messaging.entity.Tweet;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tweets")
@Interceptors({Auditor.class,Configurator.class})
@Stateless
@LocalBean
public class TwitterService {
    
    private String defaultMessage = "hugo";
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<Tweet> event;
    
    
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void tweet(Tweet tweet){
        em.persist(tweet);
        event.fire(tweet);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Tweet> all(){
        return em.createNamedQuery(Tweet.findAll).getResultList();
    }
    

}
