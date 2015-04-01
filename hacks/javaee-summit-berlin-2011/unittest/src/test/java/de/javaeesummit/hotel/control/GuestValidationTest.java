package de.javaeesummit.hotel.control;

import javax.persistence.EntityManager;
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
public class GuestValidationTest {
    
    GuestValidation cut;

    
    @Before
    public void injectEM(){
        cut = new GuestValidation();
        cut.em = mock(EntityManager.class);
    }


    @Test
    public void testSomeMethod() {
        cut.checkWithFBI();
        verify(cut.em,times(1)).persist(anyObject());
    }
}
