/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

import java.awt.Toolkit;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Startup
@Singleton
public class WakeUpController {
    @Inject 
    private int periodInSeconds;

    @Inject
    private int another;
    
    @Inject //@Precision(Precision.Level.LOW)
    TimeZoneProvider tzp;
    
    @Inject
    Event<String> message;
    
    @Resource
    SessionContext sc;
    
    @PostConstruct
    public void onStartup(){
        System.out.println("#####Starting!!!");
    }
    
    @Schedule(hour="*",minute="*",second="*/10")
    public void wakeUpAttendees(){
        Toolkit.getDefaultToolkit().beep();
        final String msg = "----- Waking up: " + this.periodInSeconds + this.tzp.getZone();
        this.message.fire(msg);
        System.out.println(msg);
    }
    
    
}
