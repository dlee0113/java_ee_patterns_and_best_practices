package com.abien.mavenunittest;

import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class EJB3WithEntityManagerTest {
    
    private EJB3WithEntityManager cut;

    @Before
    public void injectEntityManager(){
        this.cut = new EJB3WithEntityManager();
        this.cut.em = mock(EntityManager.class);
    }

    @Test
    public void testSomeMethod() {
        AnEntity ae = new AnEntity();
        this.cut.save(ae);
        verify(this.cut.em,times(1)).persist(ae);
    }

}