/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

/**
 *
 * @author abien
 */
@Stateless
public class BestQuestionEver {
    
    @Resource 
    SessionContext sc;
    
    
    @Produces
    public SessionContext create(){
        return sc;
    }
  
}
