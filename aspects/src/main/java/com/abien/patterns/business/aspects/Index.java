package com.abien.patterns.business.aspects;

import com.abien.patterns.business.aspects.cache.control.Cache;
import com.abien.patterns.business.aspects.cache.control.Shared;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index{
    
    
    @Inject @Shared
    Cache cache;
    
    public String getMessages(){
        return String.valueOf(cache.fetch("date"));
    }
}
