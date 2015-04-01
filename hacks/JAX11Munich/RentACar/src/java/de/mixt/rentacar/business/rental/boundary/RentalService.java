package de.mixt.rentacar.business.rental.boundary;

import de.mixt.rentacar.business.marketing.control.ReportSink;
import de.mixt.rentacar.business.rental.control.Auditor;
import de.mixt.rentacar.business.rental.entity.Vehicle;
import de.mixt.rentacar.business.tuning.control.CarType;
import de.mixt.rentacar.business.tuning.control.Tuner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Adam Bien <blog.adam-bien.com>
*/
@Stateless
@Interceptors({AuditorAspect.class})
public class RentalService {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    ReportSink reportSink;
    
    @Inject @Any
    Instance<Tuner> tuner;
    
    
    @PostConstruct
    public void initialize(){
        System.out.println("---Boundary initialization");
    }

    public void rent(Vehicle vehicle){
        em.persist(vehicle);
        tuner.select(new TuningSelector(CarType.Type.USUAL)).get().makeLookBetter(vehicle);
        Future<String> future = reportSink.write(vehicle);
        try {
            System.out.println("--- " + future.get());
        } catch (Exception ex) {
            System.out.println("Problem: " + ex);
        }
        
    }
    
    
}
