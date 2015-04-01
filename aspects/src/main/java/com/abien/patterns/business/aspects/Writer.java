package com.abien.patterns.business.aspects;

import com.abien.patterns.business.aspects.cache.control.Shared;
import com.abien.patterns.business.aspects.cache.control.Cache;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
public class Writer {
    
    @Inject @Shared
    Cache cache;
    
    @Schedule(minute="*",second="*/1",hour="*")
    public void writeToCache(){
        cache.cache("date", new Date());
    }
}
