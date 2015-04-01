package com.abien.business.patterns.reinjector.em.control;

import com.abien.business.patterns.reinjector.em.boundary.ReadOnly;
import com.abien.business.patterns.reinjector.em.boundary.Writable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class DataAccessOutjector {

    @PersistenceContext(unitName="read")
    EntityManager readable;
    
    @PersistenceContext(unitName="write")
    EntityManager writable;
    
    @Produces @ReadOnly
    public EntityManager readable(){
        return this.readable;
    }
    
    @Produces @Writable
    public EntityManager writable(){
        return this.writable;
    }
}
