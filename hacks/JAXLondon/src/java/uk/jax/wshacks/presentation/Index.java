package uk.jax.wshacks.presentation;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import uk.jax.wshacks.business.goodmorning.boundary.WakeUpService;
import uk.jax.wshacks.business.goodmorning.entity.Call;

@Model
public class Index {
    
    @Inject
    WakeUpService service;
    
    private Call call;
    
    @PostConstruct
    public void onCreation(){
        System.out.println("--Index created !");
        this.call  = new Call();
    }
    
    public String wakeUp(){
        return service.wakeUp();
    }

    public Call getCall() {
        return call;
    }
    
    public Object save(){
        this.service.save(this.call);
        return null;
    }
}

