/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.business.management.control;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class IronManListener {

    @Asynchronous
    public Future<String> onHello(@Observes String message){
        System.out.println("Event delivered: " + message);
        return new AsyncResult("Fire received");
    }

}
