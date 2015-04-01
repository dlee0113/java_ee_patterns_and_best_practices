package com.javaone.coolparts;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class CoolService {
    
    @Inject
    private Instance<PluginInterface> ps;
    
    @Inject
    private String message;
    
    @Inject @Coolness(Coolness.Factor.VERY_COOL)
    Event<String> event;
    
    @Resource
    SessionContext sc;
    
    public void confirmCollness(){
        for (PluginInterface pluginInterface : ps) {
            System.out.println("--- " + pluginInterface.getSomethingConfigurable());
        }
        event.fire(message);
        sc.setRollbackOnly();
        System.out.println("it is");
    }
}
