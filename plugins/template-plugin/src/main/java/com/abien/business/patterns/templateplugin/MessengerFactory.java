package com.abien.business.patterns.templateplugin;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class MessengerFactory {

    @Produces
    public Messenger create(){
        return new Messenger("localhost");
    }
}
