package com.javaone.coolparts.two;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class CoolFacade {

    @Inject
    Control control;
    
    @Inject
    Event<String> something;
    
    @Resource
    SessionContext sc;
    
    public void saveToNoSQL(){
        something.fire("and forget!");
        System.out.println("Write hashmap" + control.convertObjectToMap("hey joe"));
        sc.setRollbackOnly();
        
    }
}
