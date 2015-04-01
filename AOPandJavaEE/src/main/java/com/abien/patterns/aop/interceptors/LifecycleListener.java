package com.abien.patterns.aop.interceptors;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class LifecycleListener {
    
    private static final Logger LOG = Logger.getLogger(LifecycleListener.class.getName());
    
    @PostConstruct
    public void onCreation(){
        LOG.info("onCreation ");
    }
    
    @PreDestroy
    public void onDestruction(){
        LOG.info("onDestruction ");
    
    }
}
