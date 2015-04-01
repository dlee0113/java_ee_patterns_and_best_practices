package com.abien.patterns.business.aspects.events.boundary;

import com.abien.patterns.business.aspects.cache.control.Cache;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Decorator
public abstract class CacheChangeNotifier implements Cache{
    
    @Inject @Delegate
    Cache cache;
    
    @Inject
    Event<String> changeListeners;

    @Override
    public void cache(String key,Object value) {
        changeListeners.fire(key);
        cache.cache(key,value);
    }
}
