package com.vegas.casino.business;

import javax.enterprise.event.Observes;

/**
 *
 * @author blog.adam-bien.com
 */
public class Police {

    public void onAccident(@Observes @Money(Money.Amount.LITTLE) String message){
        System.out.println("--- Police : " + message);
    }
}
