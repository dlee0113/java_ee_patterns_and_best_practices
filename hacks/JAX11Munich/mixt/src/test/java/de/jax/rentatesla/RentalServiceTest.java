/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jax.rentatesla;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class RentalServiceTest {
    
    RentalService cut;

    @Before
    public void initDI(){
        cut = new RentalService();
        cut.cv = mock(CustomerValidation.class);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void buy() {
        when(cut.cv.cashAmount(anyInt())).thenReturn(false);
        cut.buy("tesla");
    }
}
