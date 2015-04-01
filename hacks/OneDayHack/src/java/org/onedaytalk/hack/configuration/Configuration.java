package org.onedaytalk.hack.configuration;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Singleton
@Startup
@Path("configuration")
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Configuration {
    
    @Inject
    Instance<Provider> providers;
    
    @Inject 
    Event<String> qa;
    
    @Resource
    SessionContext sc;
    
    @PostConstruct
    public void precache(){
        System.out.println("providers.isAmbiguous() " + providers.isAmbiguous());
        for (Provider provider : providers) {
            System.out.println("----" + provider.getConfiguration());
        }
    }
    
    
    
    @GET
    @javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
    public String getConfiguration(){
        String msg = "";
        for (Provider provider : providers) {
            msg += provider.getConfiguration();
        }
                qa.select(new ChannelSelector(Importance.Level.LOW)).fire(msg + new Date());
        //sc.setRollbackOnly();
        return msg;
    }
    
    @Produces
    public String getString(InjectionPoint ip){
        String name = ip.getMember().getName();
        String clazz = ip.getMember().getDeclaringClass().getName();
        return "configured message from: " + clazz + "."+ name;
    }
    
    
    @Schedule(minute="*",hour="*",second="*/5")
    public void reload(){
        reloading();
    }

    @DELETE
    public void reloading() {
        System.out.println("Reload! " + new Date());
    }
}
