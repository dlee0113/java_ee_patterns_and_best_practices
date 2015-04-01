package com.abien.patterns.business.aspects.events.boundary;

import javax.enterprise.event.Observes;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class CacheChangeListener {

    public void onCacheChanged(@Observes String cacheKey){
        System.out.println("-Cache changed!!! " + cacheKey);
    }
}
