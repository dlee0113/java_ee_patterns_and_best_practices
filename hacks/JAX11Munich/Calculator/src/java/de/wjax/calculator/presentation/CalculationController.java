/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator.presentation;

import de.wjax.calculator.Calculator;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Adam Bien <blog.adam-bien.com>
 */
@WebServlet(name = "CalculationController", urlPatterns = {"/CalculationController"},asyncSupported=true)
public class CalculationController extends HttpServlet {

    @Inject
    Event<AsyncContext> calculator;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AsyncContext startAsync = request.startAsync();
        calculator.fire(startAsync);
        
    }

}
