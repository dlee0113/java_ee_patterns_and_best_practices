package de.jax.royalwedding.business.wedlock.control;

import de.jax.royalwedding.business.wedlock.boundary.Channel;
import javax.enterprise.event.Observes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Illuminati {
    
    public void itHappened(@Observes @Channel(Channel.Confidentiality.PRIVATE) String message){
        System.out.println("∆∆∆∆∆∆ " + message);
    }
}
