package com.abien.wisdomator.business.wisdom.control;

import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@Singleton
@DeclareRoles("dukes")
public class WisdomStorage {
    
    private String wisdom;

    @Inject
    Principal principal;
    
    @PostConstruct
    public void initialize(){
        wisdom = "Java Programming Language Rocks!!!";
    }
    
    @RolesAllowed("dukes")
    public void wisdom(String wisdom){
        this.wisdom = wisdom;
    }
    
    @PermitAll
    public String wisdom(){
        return wisdom;
    }
}
