package com.abien.injection.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@PersistenceContext(name=ControlWithEMLookup.JNDI_NAME)
public class ControlWithEMLookup {

    public final static String JNDI_NAME = "default";
    private EntityManager em;

    @Resource
    private SessionContext context;


    @PostConstruct
    public void lookupEntityManager(){
        this.em = (EntityManager) this.context.lookup(JNDI_NAME);
        System.out.println("Got EntityManager: " + this.em);
    }

    public void save(PersistentEntity entity){
        this.em.persist(entity);
    }

    public PersistentEntity find(long id){
        return this.em.find(PersistentEntity.class, id);
    }
}
