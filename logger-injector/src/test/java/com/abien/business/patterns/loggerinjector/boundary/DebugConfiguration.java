package com.abien.business.patterns.loggerinjector.boundary;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam-bien.com
 */
public class DebugConfiguration{
    @Produces
    public final static boolean debug = true;
    
    
}
