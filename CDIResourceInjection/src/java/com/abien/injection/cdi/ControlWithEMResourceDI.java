package com.abien.injection.cdi;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@PersistenceContext(name=ControlWithEMResourceDI.JNDI_NAME)
public class ControlWithEMResourceDI {

    public final static String JNDI_NAME = "default";

    @Resource(lookup="java:comp/env/" + JNDI_NAME)
    private EntityManager em;

    public void save(PersistentEntity entity){
        this.em.persist(entity);
    }

    public PersistentEntity find(long id){
        return this.em.find(PersistentEntity.class, id);
    }
}
