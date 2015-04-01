package com.abien.messageme.business.messaging.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class MessageTest {

    @Test
    public void mappingSmokeTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Message("duke"));
        tx.commit();
    }

}