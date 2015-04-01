/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.oop.etrade.business.ordering.boundary;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abien
 */
public class QuoteServiceTest {


    @Test
    public void testGetQuote() throws Exception {
        System.out.println("getQuote");
        QuoteService instance = (QuoteService)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/QuoteService");
        float expResult = 42.0F;
        float result = instance.getQuote();
        assertEquals(expResult, result, 0.0);
    }

}