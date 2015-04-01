package de.jax.erw.presentation;

import de.jax.erw.business.wedding.boundary.RoyalWeddingService;
import de.jax.erw.business.wedding.entity.WedLock;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Presenter
public class Index {
    
    @EJB
    RoyalWeddingService rws;
    
    private WedLock lock = new WedLock();
    
    @PostConstruct
    public void beforeWedding(){
        System.out.println("I'm so free! " + rws);
    }

    public WedLock getLock() {
        return lock;
    }
    
    public Object heirateMich(){
        rws.performWedLock(lock);
        return null;
    }
    public String getWeddingMessage(){
        return "I love you - transaction committed! " + rws;
    }
    
    @PreDestroy
    public void afterWedding(){
        System.out.println("I'm so lucky!");
    }
    
}
