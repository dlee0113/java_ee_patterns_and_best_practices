package com.abien.patterns.business.aspects.cache.control;

import com.abien.patterns.business.aspects.monitoring.Monitorable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Monitorable
public class InMemoryCache implements Cache{
    
    private ConcurrentMap<String,Object> cache;
    
    @PostConstruct
    public void init(){
        this.cache = new ConcurrentHashMap<>();
    }
    
    @Override
    public void cache(String key,Object value){
        this.cache.put(key, value);
    }
    
    @Override
    public Object fetch(String key) {
         return this.cache.get(key);
    }
}
