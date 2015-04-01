package com.abien.business.patterns.lpi.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class MessengerFactory {

    @Produces @Connected
    public Messenger create(Messenger messenger){
        messenger.setHost("locahost");
        messenger.setPort(8080);
        messenger.connect();
        return messenger;
    }
    
    @Produces
    public IncompatibleMessenger create(){
        IncompatibleMessenger im = new IncompatibleMessenger("localhost", 80);
        im.connect();
        return im;
    }
}
