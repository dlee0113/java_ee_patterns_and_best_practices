package com.abien.patterns.business.cacheintegrator.caching.control;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MapCacheIntegrator {
    
    private ConcurrentHashMap<String,Object> cache;
    
    @PostConstruct
    public void initialize(){
        this.cache = new ConcurrentHashMap<>();
    }
    
    @Produces @Cache
    public ConcurrentMap<String,Object> expose(){
        return cache;
    }
}
