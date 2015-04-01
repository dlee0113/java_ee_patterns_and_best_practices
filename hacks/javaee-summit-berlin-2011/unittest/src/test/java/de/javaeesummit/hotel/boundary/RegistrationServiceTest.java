package de.javaeesummit.hotel.boundary;

import de.javaeesummit.hotel.control.GuestValidation;
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
public class RegistrationServiceTest {
    
    RegistrationService cut;

    @Before
    public void inject(){
        this.cut = new RegistrationService();
        this.cut.gv = new GuestValidation();
    }

    @Test
    public void registrationOfUnsuspiciousGuest() {
        this.cut.gv = mock(GuestValidation.class);
        when(this.cut.gv.checkWithFBI()).thenReturn(42);
        assertTrue(this.cut.registered());
        verify(this.cut.gv,times(1)).checkWithFBI();
    }
    
    @Test(expected=IllegalStateException.class)
    public void registerSuspicousGuest(){
        this.cut.gv = mock(GuestValidation.class);
        when(this.cut.gv.checkWithFBI()).thenReturn(21);
        this.cut.registered();
    }
}
