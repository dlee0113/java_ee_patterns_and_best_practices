package com.abien.patterns.business.httpevents.publish;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adam bien, adam-bien.com
 */
@WebServlet(name = "Publisher", urlPatterns = {"/Publisher"},asyncSupported=true)
public class Publisher extends HttpServlet {

    @Inject
    Event<BrowserWindow> listeners;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        AsyncContext async = request.startAsync();
        listeners.fire(new BrowserWindow(async));
    }
}
