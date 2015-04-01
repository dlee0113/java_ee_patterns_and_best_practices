package com.javaone.coolparts.two;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("larry")
@RequestScoped
public class Index {
   
    @Inject
    CoolFacade cf;
    
    
    public Object save(){
        cf.saveToNoSQL();
        System.out.println("--- saved!");
        return null;
    }
}
