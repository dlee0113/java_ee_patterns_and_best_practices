package com.abien.patters.serviceactivator.business;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class SynchronousService {
    @Asynchronous
    public void message(String message){
        System.out.println("--- "+ message);
    }
}
