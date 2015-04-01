package de.novatec.wms.business.spamming.boundary;

import de.novatec.wms.business.registration.entity.Workshop;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author blog.adam-bien.com
 */
@DependsOn("hugo")
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class RegistrationListener {


    private CopyOnWriteArrayList<Workshop> cache = new CopyOnWriteArrayList<Workshop>();

    @PostConstruct
    public void onStart(){
        System.out.println("---------Started!");
    }


    @Asynchronous
    public Future<String> onNewRegistration(@Observes Workshop workshop){
            System.out.println("Received !: " + workshop);
            cache.add(workshop);
        return new AsyncResult("hello");
    }

    //@Schedule(minute="*",second="*/5",hour="*",persistent=true)
    public void sendMails(){
        System.out.println("---------- " + new Date());
        for (Workshop workshop : cache) {
            System.out.println("Send workshop via email: " + workshop);
            //cache.remove(workshop);
        }
    }
}
