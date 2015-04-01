/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class ResultListener {
    
    private CopyOnWriteArrayList<AsyncContext> browsers;
    
    
    @PostConstruct
    public void initialize(){
        this.browsers = new CopyOnWriteArrayList<AsyncContext>();
    }
    
    public void onResult(@Observes String result){
        for (AsyncContext asyncContext : browsers) {
            try {
                PrintWriter writer = asyncContext.getResponse().getWriter();
                writer.println(result);
                writer.flush();
                asyncContext.complete();
            } catch (IOException ex) {
                Logger.getLogger(ResultListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.browsers.remove(asyncContext);
        }
    }
    
    public void onNewBrowser(@Observes AsyncContext ac){
        browsers.add(ac);
    }
    
}
