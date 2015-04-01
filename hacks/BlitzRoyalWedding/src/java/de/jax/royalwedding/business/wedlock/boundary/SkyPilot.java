package de.jax.royalwedding.business.wedlock.boundary;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("skypilot")
@Stateless
public class SkyPilot {
    
    @Inject @Channel(Channel.Confidentiality.PUBLIC)
    Event<String> pressSink;
    
    @Inject @Channel(Channel.Confidentiality.PRIVATE)
    Event<String> audit;
    
    @Resource
    SessionContext sc;
    
    @Inject
    PrincipalWitness principalWitness;
    
    @Inject
    private String message = "You are locked!";
    
    @Inject
    private String decision;
    
    @PostConstruct
    public void init(){
        this.message += principalWitness.ok();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
        audit.fire("Keep it secret "+ message + " decision: " + decision);
        pressSink.fire(message);
        return message;
    }
}
