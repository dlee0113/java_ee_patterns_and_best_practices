package com.javaone.coolparts;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    CoolService coolService;
    
    @PostConstruct
    public void onCreation(){
        System.out.println("Created!");
    }
    
    public Object ok(){
        System.out.println("Java EE 6 is cool");
        coolService.confirmCollness();
        return null;
    }
    
}
