package com.abien.injection.cdi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ControlWithJPADI {

    @PersistenceContext
    EntityManager em;

    public void save(PersistentEntity entity){
        this.em.persist(entity);
    }

    public PersistentEntity find(long id){
        return this.em.find(PersistentEntity.class, id);
    }
}
