package com.abien.business.patterns.lpi.boundary;

import com.abien.business.patterns.lpi.control.Connected;
import com.abien.business.patterns.lpi.control.IncompatibleMessenger;
import com.abien.business.patterns.lpi.control.Messenger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class OrderService {
    
    @Inject @Connected
    Messenger messenger;

    @Inject
    IncompatibleMessenger im;
    
    public void order(){
        messenger.send("You ordered some stuff!");
        im.send("...");
    }
}
