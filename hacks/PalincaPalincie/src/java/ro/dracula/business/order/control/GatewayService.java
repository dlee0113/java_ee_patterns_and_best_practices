package ro.dracula.business.order.control;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import ro.dracula.business.order.entity.FireFluid;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
@Startup
public class GatewayService {

    private CopyOnWriteArrayList<FireFluid> transport;


    @PostConstruct
    public void initializeTransport(){
        transport = new CopyOnWriteArrayList<FireFluid>();
        System.out.println("Transport Initialized! ");
    }

    public void onArrival(@Observes FireFluid ff){
        transport.add(ff);

        System.out.println("Transport: " + ff);
    }

    @Schedule(second="*/5",minute="*",hour="*")
    public void deliverToAustria(){
        System.out.println("Delivered: " + transport.size() + " " + new Date());
        transport.clear();
    }

}
