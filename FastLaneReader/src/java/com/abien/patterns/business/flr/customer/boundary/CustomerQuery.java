package com.abien.patterns.business.flr.customer.boundary;

import com.abien.patterns.business.flr.customer.entity.Customer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adam Bien, www.adam-bien.com
 */
@Stateful
public class CustomerQuery implements Iterator<List<Customer>> {

    @PersistenceContext
    private EntityManager em;
    
    private int index = 0;
    private int chunkSize = 10;
    
    private boolean next = true;
    
    public CustomerQuery() {  }

    public void setChunkSize(int chunkSize){
        this.chunkSize = chunkSize;
    }
    
    
    public List<Customer> next(){
        List<Customer> retVal = null;
        Query query = this.em.createNamedQuery(Customer.findAll);
        query.setFirstResult(getFirst());
        query.setMaxResults(chunkSize);
        retVal =  query.getResultList();
        if(retVal.isEmpty()){
            this.next = false;
        }
        index++;
        return retVal;
    }
    
    private int getFirst(){
        return index * chunkSize;
    }
    
    @Remove
    public void close(){
        //cleanup resources
    }

    @Override
    public boolean hasNext() {
        return this.next;
    }

    @Override
    public void remove() {
        throw new IllegalStateException("Operation remove is not supported in the paginator");
    }

  

  
}
