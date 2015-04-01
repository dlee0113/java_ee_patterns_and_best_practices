package de.jax.royalwedding.business.wedlock.control;

import de.jax.royalwedding.business.wedlock.boundary.Channel;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class Press {
    
    
    
    public void onSuccessfulWedLockNews(@Observes(during= TransactionPhase.AFTER_COMPLETION) @Channel(Channel.Confidentiality.PUBLIC) String messages){
        System.out.println("++++++ " + messages);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void onFailedWedLockNews(@Observes(during= TransactionPhase.AFTER_FAILURE) String messages){
        System.out.println("-------- " + messages);
    }
    
}
