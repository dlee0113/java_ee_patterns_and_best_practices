package com.abien.business.patterns.loggerinjector.boundary;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam-bien.com
 */
public class Configuration {
    
    @Produces
    public final static boolean debug = false;
}
