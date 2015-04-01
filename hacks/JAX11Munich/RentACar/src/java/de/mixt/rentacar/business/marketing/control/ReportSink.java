/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.marketing.control;

import de.mixt.rentacar.business.rental.entity.Vehicle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ReportSink {
    
    private CopyOnWriteArrayList<Vehicle> cache = new CopyOnWriteArrayList<Vehicle>();
    
    @Inject
    Event<Vehicle> events;
    
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<String> write(Vehicle ve){
        cache.add(ve);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReportSink.class.getName()).log(Level.SEVERE, null, ex);
        }
        events.fire(ve);
        return new AsyncResult<String>("Your confirmation: " + System.currentTimeMillis());
    }
    
    //@Schedule(hour="*",minute="*",second="*/5")
    public void sendViaGermanMail(){
        System.out.println("--- " + cache + " " + new Date());
        cache.clear();
    }
}
