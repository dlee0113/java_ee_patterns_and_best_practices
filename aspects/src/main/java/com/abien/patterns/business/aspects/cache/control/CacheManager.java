package com.abien.patterns.business.aspects.cache.control;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CacheManager {

    @Inject
    Cache cache;
    
    @Produces @Shared
    public Cache shared(){
        return cache;
    } 
}
