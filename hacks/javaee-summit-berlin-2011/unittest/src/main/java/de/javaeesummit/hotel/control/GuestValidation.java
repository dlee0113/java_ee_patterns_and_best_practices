package de.javaeesummit.hotel.control;

import de.javaeesummit.hotel.entity.Guest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */

public class GuestValidation {
    
    @PersistenceContext
    EntityManager em;

    public int checkWithFBI(){
        em.persist(new Guest("duke"));
        return 42;
    }
}
