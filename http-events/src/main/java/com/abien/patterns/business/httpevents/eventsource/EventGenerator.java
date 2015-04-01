package com.abien.patterns.business.httpevents.eventsource;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Startup
@Singleton
public class EventGenerator {
    
    @Inject
    Event<String> message;
    
    @Schedule(minute="*",second="*/1",hour="*")
    public void sendTime(){
        message.fire(new Date().toString());
        System.out.println(".");
    }
}
