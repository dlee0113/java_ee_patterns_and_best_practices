package com.abien.patterns.business.httpevents.broker;

import com.abien.patterns.business.httpevents.publish.BrowserWindow;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.Before;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class BatchEventBrokerTest {
    
    BatchEventBroker cut;
    
    @Before
    public void init(){
        cut = new BatchEventBroker();
    }
    
    @Test
    public void notifyWindowsWithoutEvents() {
        BrowserWindow bw = mock(BrowserWindow.class);
        cut.onBrowserRequest(bw);
        cut.sendEventBatch();
        verify(bw).nothingToSay();
        verify(bw,never()).sendAndCommit(anyString());
        verify(bw).commit();
    }

    @Test
    public void notifyWindowsWithEvents() {
        String message = "duke";
        BrowserWindow bw = mock(BrowserWindow.class);
        cut.onBrowserRequest(bw);
        cut.onNewEvent(message);
        cut.sendEventBatch();
        verify(bw,never()).nothingToSay();
        verify(bw,never()).sendAndCommit(anyString());
        verify(bw).commit();
        verify(bw).send(message);
    }
    
    @Test
    public void sendBatch(){
        cut.sendEventBatch();
    }

    @Test
    public void sendBatchWithoutWindows(){
        cut.onNewEvent("first");
        cut.onNewEvent("second");
        cut.sendEventBatch();
    }
}
