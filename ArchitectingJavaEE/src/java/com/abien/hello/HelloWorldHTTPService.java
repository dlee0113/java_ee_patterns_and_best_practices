package com.abien.hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@WebServlet(name="HelloWorldService", urlPatterns={"/HelloWorldService"})
public class HelloWorldHTTPService extends HttpServlet {
   
    @Inject
    private Hello hello;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(hello.helloWorld());
        out.flush();
        out.close();
    } 
}
