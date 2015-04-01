package com.abien.patterns.business.flr.customer.boundary;

import com.abien.patterns.business.flr.customer.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Bien, www.adam-bien.com
 */
@Stateless
public class CustomerQueryNameExtractor{

    @PersistenceContext
    private EntityManager em;
    
    public List<String> next(){
        // SELECT c.name FROM Customer c
        return this.em.createQuery(Customer.findAllNames).getResultList();
    }
}
