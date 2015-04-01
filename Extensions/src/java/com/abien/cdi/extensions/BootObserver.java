package com.abien.cdi.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class BootObserver implements Extension{

    public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event){
        System.out.println("--- " + event);
    }
    
    public void afterBeanDiscovery(@Observes AfterBeanDiscovery event, BeanManager manager){
        System.out.println("--- " + event);
    }
 
    public void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager manager){
            System.out.println("--- " + event);

    }
    public void beforeShutdown(@Observes BeforeShutdown event, BeanManager manager){
            System.out.println("---" + event);
    }
    public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat){
        System.out.println("--- " + pat);
    }
}
