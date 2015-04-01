/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.control;

import de.mixt.rentacar.business.configuration.boundary.ConfigurationSource;
import de.mixt.rentacar.business.rental.entity.Vehicle;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Auditor {
    
    @Inject 
    private String msg;
    
    @Inject
    private String delimiter;
    
    
    @PostConstruct
    public void initialize(){
        System.out.println("---Control initialization");
    }
    
    
    public void audit(String v){
        System.out.println(msg + delimiter + v);
}
    
}
