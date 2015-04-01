package com.abien.ejbandcdi.control;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 *
 * @author blog.adam-bien.com
 */
@Alternative
public class LocalCustomerNotification implements CustomerNotification{

    @Inject
    Event<String> event;

    @Override
    public void sendNotification() {
        event.fire("Order proceeded!");
        System.out.println("Local event distribution!");
    }

}
