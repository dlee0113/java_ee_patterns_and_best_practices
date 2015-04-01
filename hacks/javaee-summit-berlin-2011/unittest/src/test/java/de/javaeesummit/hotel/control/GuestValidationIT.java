package de.javaeesummit.hotel.control;

import de.javaeesummit.hotel.entity.Guest;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;


/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class GuestValidationIT {
    
    GuestValidation cut;

    private EntityManager em;
    private EntityTransaction tx;
    
    @Before
    public void injectEM(){
        this.em = Persistence.createEntityManagerFactory("it").createEntityManager();
        this.tx = em.getTransaction();
        cut = new GuestValidation();
        cut.em = this.em;
    }


    @Test
    public void testSomeMethod() {
        this.tx.begin();
        this.em.persist(new Guest("duke"));
        this.tx.commit();
    }
}
