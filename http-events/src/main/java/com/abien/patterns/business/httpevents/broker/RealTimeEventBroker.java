package com.abien.patterns.business.httpevents.broker;

import com.abien.patterns.business.httpevents.publish.BrowserWindow;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class RealTimeEventBroker {

    private ConcurrentLinkedQueue<BrowserWindow> browsers = new ConcurrentLinkedQueue<>();
    
    public void onBrowserRequest(@Observes BrowserWindow browserWindow) {
        browsers.add(browserWindow);
    }

    public void onNewEvent(@Observes String message) {
        for (BrowserWindow browserWindow : browsers) {
                try {
                    browserWindow.sendAndCommit(message);
                } finally {
                    browsers.remove(browserWindow);
                }
        }
    }
}
