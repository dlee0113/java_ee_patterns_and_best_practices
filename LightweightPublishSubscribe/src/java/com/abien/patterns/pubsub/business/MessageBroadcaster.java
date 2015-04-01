package com.abien.patterns.pubsub.business;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class MessageBroadcaster {
    
    @Inject
    Event<String> event;
    
    public void broadcast(String message){
        event.select(new ImportanceSelector(Importance.Degree.HIGH)).fire(message);
    }
    
}
