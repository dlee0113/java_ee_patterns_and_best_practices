package com.abien.smokingservers.business.smoke.control;

import javax.enterprise.event.Observes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SmokeListener {

    public void isSomethingSmoking(@Observes Boolean smoke){
        if(!smoke){
            System.out.println("Cool - there is no smoke");
        }
    }
}
