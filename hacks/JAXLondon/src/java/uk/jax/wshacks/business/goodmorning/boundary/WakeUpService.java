package uk.jax.wshacks.business.goodmorning.boundary;

import java.util.Date;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import uk.jax.wshacks.business.goodmorning.control.Clock;
import uk.jax.wshacks.business.goodmorning.entity.Call;

@Stateless
@Interceptors(CallAudit.class)
public class WakeUpService {
    
    @Inject
    Clock clock;
    
    @Inject
    Event<String> call;
    
    @Inject
    Validator validator;
    
    @Resource
    SessionContext sc;
    
    @PersistenceContext
    EntityManager em;
    
    @PostConstruct
    public void onCreation(){
        System.out.println("--WakeUpService created !");
    }

    public String wakeUp(){
        em.persist(new Call("duke", System.currentTimeMillis()));
        call.fire("Please wake up!");
        //sc.setRollbackOnly();
        return "Wake up! (with clock) " + clock.time();
    }//

    public void save(Call call) {
        Set<ConstraintViolation<Call>> validate = validator.validate(call, new Class[]{});
        for (ConstraintViolation<Call> violation : validate) {
            System.out.println("Violation!!! " + violation);
            
        }
        em.persist(call);
    }
}
