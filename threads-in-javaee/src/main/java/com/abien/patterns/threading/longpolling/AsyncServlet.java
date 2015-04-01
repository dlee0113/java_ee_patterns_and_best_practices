package com.abien.patterns.threading.longpolling;

import java.io.IOException;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adam bien, adam-bien.com
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/listen"},asyncSupported=true)
public class AsyncServlet extends HttpServlet {

    @Inject
    Event<AsyncContext> event;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(-1);
        event.fire(asyncContext);
    }
}
