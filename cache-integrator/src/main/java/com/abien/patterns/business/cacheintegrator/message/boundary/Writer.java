package com.abien.patterns.business.cacheintegrator.message.boundary;

import com.abien.patterns.business.cacheintegrator.caching.control.Cache;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
public class Writer {
    @Inject @Cache
    ConcurrentMap<String, Object> cache;
    
    @Schedule(minute="*",second="*/1",hour="*")
    public void writeToCache(){
        cache.put("date", new Date());
    }
}
