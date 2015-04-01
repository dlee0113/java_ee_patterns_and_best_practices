/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.oop.etrade.presentation;

import de.oop.etrade.business.ordering.boundary.QuoteService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;
/**
 *
 * @author abien
 */
public class IndexTest {


    @Test
    public void getTrade() {
        Index index = new Index();
        index.service = mock(QuoteService.class);
        when(index.service.getQuote()).thenReturn(42.0f);

        String actual = index.getTrade();
        verify(index.service,times(0)).getQuote();
        String expected = "Trade: 42.0";
        assertThat(actual, is(expected));
    }

}