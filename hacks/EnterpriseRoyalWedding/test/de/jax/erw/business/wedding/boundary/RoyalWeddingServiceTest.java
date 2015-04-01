/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jax.erw.business.wedding.boundary;

import de.jax.erw.business.wedding.control.SkyPilot;
import de.jax.erw.business.wedding.entity.WedLock;
import javax.enterprise.event.Event;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class RoyalWeddingServiceTest {
    
    RoyalWeddingService cut;
    
    @Before
    public void init(){
        cut = new RoyalWeddingService();
        cut.em = mock(EntityManager.class);
        cut.pilot = mock(SkyPilot.class);
        cut.wedlockSink = mock(Event.class);
    }

    @Test(expected=IllegalStateException.class)
    public void crazySkyPilotWedLock() {
        when(this.cut.pilot.validate(null)).thenReturn(false);
        this.cut.performWedLock(null);
        verify(this.cut.wedlockSink,times(2)).fire(null);
    }

    @Test
    public void reasonableSkyPilotWedLock() {
        when(this.cut.pilot.validate(null)).thenReturn(true);
        this.cut.performWedLock(null);
        verify(this.cut.wedlockSink,times(1)).fire(null);
    }
}
