/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.novatec.wms.presentation;

import de.novatec.wms.business.registration.boundary.WorkshopRegistration;
import de.novatec.wms.business.registration.entity.Workshop;
import javax.swing.text.DefaultEditorKit.CutAction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author abien
 */
public class IndexTest {

    Index cut;

    @Before
    public void initialize(){
        cut = new Index();
        cut.ws = mock(WorkshopRegistration.class);
    }

    @Test
    public void newRegister() {
        cut.newRegistration();
        Workshop expected = cut.getWorkshop();
        verify(cut.ws,times(1)).register(expected);
    }

    @Test
    public void newRegisterWithBoundaryError() {
        cut.newRegistration();
        Workshop expected = cut.getWorkshop();
        when(cut.ws).thenThrow(new Exception(""));
    }

}