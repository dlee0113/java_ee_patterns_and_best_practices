package com.abien.patterns.business.httpevents.broker;

import com.abien.patterns.business.httpevents.publish.BrowserWindow;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class BatchEventBroker {

    private ConcurrentLinkedQueue<BrowserWindow> browsers = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<String> events = new ConcurrentLinkedQueue<>();

    public void onBrowserRequest(@Observes BrowserWindow browserWindow) {
        browsers.add(browserWindow);
    }

    public void onNewEvent(@Observes String message) {
        events.add(message);
    }

    @Schedule(second="*/5",minute="*",hour="*")
    public void sendEventBatch() {
        for (BrowserWindow browserWindow : browsers) {
            try {
                if(events.isEmpty()){
                    browserWindow.nothingToSay();
                }else{
                    for (String event : events) {
                        browserWindow.send(event);
                    }
                }
            } finally {
                browserWindow.commit();
                browsers.remove(browserWindow);
            }
        }
        events.clear();
    }
}
