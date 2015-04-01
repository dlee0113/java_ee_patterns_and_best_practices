package com.abien.business.patterns.templateplugin;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class RemoteMessengerFactory extends MessengerFactory{

    @Override @Produces @Specializes
    public Messenger create() {
        return new Messenger("remote");
    }
}
