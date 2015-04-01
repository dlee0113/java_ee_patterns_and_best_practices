package com.abien.business.patterns.loggerinjector.boundary;

import javax.inject.Inject;

/**
 *
 * @author blog.adam-bien.com
 */
public class LogUser {
    
    @Inject
    private Log LOG;
    

    public boolean isLogInjected(){
        return (LOG != null);
    }

    public Log getLogger() {
        return LOG;
    }
}
