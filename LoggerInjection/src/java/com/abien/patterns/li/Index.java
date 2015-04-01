package com.abien.patterns.li;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Named
@Stateless
public class Index {
    
    
    @Inject 
    Logger logger;
    
    public Object ok(){
        logger.info("Ok!");
        return null;
    }
}
