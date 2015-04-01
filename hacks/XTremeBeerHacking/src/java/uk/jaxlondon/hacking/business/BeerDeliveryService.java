package uk.jaxlondon.hacking.business;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Validator;

/**
 *
 * @author abien
 */
//@Interceptors(BeerDeliveryQA.class)
@Stateless
public class BeerDeliveryService {
    
    @Inject
    Event<String> beerRequest;
    
    @Inject
    SessionContext sc;
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    private String message;
    
    @Inject
    private String transactionName;
    
    @Inject
    Logger log;
    
    @Inject
    FutureIsBright fib;
    
    @Inject
    Event<Future> event;
    
    @Inject @Any
    Instance<BeverageProvider> bp;
    
    
    

    public String getBeer(){
        log.info("Should work (hopefully)");
        beerRequest.fire(message);
        sc.setRollbackOnly();
        System.out.println("Producing like crazy");
        
        return "Bud sponsored by angry nerds";
    }
    
    public void save(Bottle bottle){
                log.info("Should work (hopefully)");
        Future<String> result = fib.causeException();
        try {
            result.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(BeerDeliveryService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Throwable cause = ex.getCause();
            System.out.println("Works as expected: " + cause.toString());
        }

        for (BeverageProvider beverageProvider : bp) {
            log.info("Provider: " + beverageProvider);
        }
        //log.info("Got some food: " + food);
        //event.fire(result);
        beerRequest.fire(message + " TX: " + transactionName);
        em.persist(bottle);
    }
}
