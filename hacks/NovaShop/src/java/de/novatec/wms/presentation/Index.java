package de.novatec.wms.presentation;

import de.novatec.wms.business.registration.boundary.WorkshopRegistration;
import de.novatec.wms.business.registration.entity.Workshop;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Presenter
public class Index {

    @EJB
    WorkshopRegistration ws;

    private Workshop workshop = new Workshop();

    @PostConstruct
    public void onInitialize(){
        //not needed -> workshop
        System.out.println("Initialized !");
    }

    public Workshop getWorkshop() {
        return workshop;
    }


    
    public Object newRegistration(){
        try{
            ws.register(workshop);
        }catch(Exception e){
            throw new IllegalStateException("Cannot invoke boundary");
        }
        return "registered";
    }


    public String getHello(){
        return "Novatec from ejb @" + ws.getDate();
    }
}
