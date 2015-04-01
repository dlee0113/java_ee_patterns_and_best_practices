package com.abien.mavenunittest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class EJB3WithEntityManager {
    
    @PersistenceContext
    EntityManager em;
    
    public void save(AnEntity ae){
        em.persist(ae);
    }

}
