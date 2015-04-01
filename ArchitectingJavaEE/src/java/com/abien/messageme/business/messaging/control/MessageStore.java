package com.abien.messageme.business.messaging.control;

import com.abien.messageme.business.messaging.entity.Message;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class MessageStore {
    @PersistenceContext
    EntityManager em;
    public void store(Message message){
        em.persist(message);
    }
}
