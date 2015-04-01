package com.abien.testing.oracle.boundary;

import com.abien.testing.oracle.control.Consultant;
import com.abien.testing.oracle.entity.Result;
import static com.abien.testing.oracle.entity.Result.*;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("javafuture")
@Stateless
public class OracleResource {
    
    @Inject
    Instance<Consultant> company;
    
    @Inject
    Event<Result> eventListener;
    
    @Inject
    private String javaIsDeadError;
    @Inject
    private String noConsultantError;
        
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String predictFutureOfJava(){
        checkConsultantAvailability();
        Consultant consultant = getConsultant();
        Result prediction = consultant.predictFutureOfJava();
        eventListener.fire(prediction);
        if(JAVA_IS_DEAD.equals(prediction)){
            throw new IllegalStateException(this.javaIsDeadError);
        }
        return prediction.name();
    }
    
    void checkConsultantAvailability(){
        if(company.isUnsatisfied()){
            throw new IllegalStateException(this.noConsultantError);
        }
    }
    
    Consultant getConsultant(){
        for (Consultant consultant : company) {
            return consultant;
        }
        return null;
    }
}
