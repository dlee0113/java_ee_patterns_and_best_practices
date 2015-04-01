package com.abien.wisdomator.business.wisdom.control;

import com.abien.wisdomator.business.security.boundary.AllowedTo;
import com.abien.wisdomator.business.security.boundary.Guard;
import com.abien.wisdomator.business.security.entity.Permission;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

/**
 *
 * @author adam-bien.com
 */
@Singleton
@Interceptors(Guard.class)
public class CustomSecuredWisdomStorage {
    
    private String wisdom;

    @PostConstruct
    public void initialize(){
        wisdom = "Java Programming Language Rocks!!!";
    }
    
    @AllowedTo(Permission.WRITE)
    public void wisdom(String wisdom){
        this.wisdom = wisdom;
    }
    
    @AllowedTo(Permission.READ)
    public String wisdom(){
        return wisdom;
    }
}
