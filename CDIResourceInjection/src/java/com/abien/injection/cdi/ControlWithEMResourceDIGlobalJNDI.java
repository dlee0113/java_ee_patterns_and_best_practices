package com.abien.injection.cdi;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@PersistenceContext(name=ControlWithEMResourceDIGlobalJNDI.JNDI_NAME)
public class ControlWithEMResourceDIGlobalJNDI {

    public final static String JNDI_NAME = "java:global/default";

    @Resource(name=JNDI_NAME)
    private EntityManager em;

    public void save(PersistentEntity entity){
        this.em.persist(entity);
    }

    public PersistentEntity find(long id){
        return this.em.find(PersistentEntity.class, id);
    }
}
