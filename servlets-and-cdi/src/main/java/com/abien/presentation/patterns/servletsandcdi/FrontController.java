package com.abien.presentation.patterns.servletsandcdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adam-bien.com
 */
@WebServlet(name = "FrontController", loadOnStartup=1,urlPatterns = {"/FrontController/*"})
public class FrontController extends HttpServlet {

    @Inject
    SessionStore store;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String payload = store.getPayload();
            final PrintWriter out = response.getWriter();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                out.println(name + " : " + value);
            }

            String uri = request.getRequestURI();
            out.println("Payload: " + payload);
            out.println("# of sessions : " + SessionStore.INSTANCE_COUNT.get());
            store.setPayload(uri);
        }
        
    }


