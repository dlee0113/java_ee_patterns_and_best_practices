package de.duke.mugs.business.order.control;

import de.duke.mugs.business.order.entity.DukeMug;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;

/**
 *
 * @author blog.adam-bien.com
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
@Startup
public class BulkMugDelivery {

    private CopyOnWriteArrayList<DukeMug> mugCache = new CopyOnWriteArrayList<DukeMug>();

    @PostConstruct
    public void onInitialize(){

        System.out.println("----Initializebd: !");
    }

    public void onAnsweredQuestion(@Observes DukeMug dm){
        System.out.println("------- from Singleton " + dm);
        mugCache.add(dm);
    }


    @Schedule(minute="*",second="*/5",hour="*")
    public void bulkDeliver(){
        for (DukeMug dukeMug : mugCache) {
            System.out.println("Bulk deliver !!! " + dukeMug);
        }
        mugCache.clear();
    }
}
