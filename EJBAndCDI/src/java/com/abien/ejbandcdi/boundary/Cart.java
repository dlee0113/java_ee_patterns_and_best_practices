package com.abien.ejbandcdi.boundary;

import com.abien.ejbandcdi.control.OrderSystem;
import com.abien.ejbandcdi.control.CustomerNotification;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author blog.adam-bien.com
 */
@Named
@Stateless
public class Cart {

    @Inject
    OrderSystem ordering;
    
    @Inject
    CustomerNotification notifier;

    public void checkout(){
        ordering.placeOrder();
        notifier.sendNotification();
    }
}
