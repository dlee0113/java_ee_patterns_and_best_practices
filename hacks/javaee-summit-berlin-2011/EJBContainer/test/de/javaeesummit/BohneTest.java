package de.javaeesummit;

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class BohneTest {
    
    public BohneTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hey method, of class Bohne.
     */
    @Test
    public void testHey() throws Exception {
        System.out.println("hey");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Bohne instance = (Bohne)container.getContext().lookup("java:global/classes/Bohne");
        String expResult = "";
        String result = instance.hey();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
