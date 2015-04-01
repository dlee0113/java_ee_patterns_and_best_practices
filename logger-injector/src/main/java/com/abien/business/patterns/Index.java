package com.abien.business.patterns;

import com.abien.business.patterns.loggerinjector.boundary.Log;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@Model
public class Index {

    @Inject
    Log logger;
    
    public Object ok(){
        logger.info("ok clicked!");
        return null;
    }
}
