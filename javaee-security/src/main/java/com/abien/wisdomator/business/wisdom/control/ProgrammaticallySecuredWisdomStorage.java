package com.abien.wisdomator.business.wisdom.control;

import com.abien.wisdomator.business.wisdom.control.*;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@Singleton
@DeclareRoles("dukes")
public class ProgrammaticallySecuredWisdomStorage {
    
    private String wisdom;

    @Inject
    Principal principal;
    
    @Resource
    SessionContext sc;
    
    @PostConstruct
    public void initialize(){
        wisdom = "Java Programming Language Rocks!!!";
    }
    
    public void wisdom(String wisdom){
        if(!sc.isCallerInRole("dukes")) {
            throw new IllegalStateException("Only dukes can change the wisdom! Are you a blogger?");
        }
        this.wisdom = wisdom;
    }
    
    public String wisdom(){
        return wisdom;
    }
}
