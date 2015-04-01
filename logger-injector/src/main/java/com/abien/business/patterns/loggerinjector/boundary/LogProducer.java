package com.abien.business.patterns.loggerinjector.boundary;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 * @author blog.adam-bien.com
 */
public class LogProducer {

    @Inject
    private boolean debug;

    @Produces
    public Log getLogger(InjectionPoint ip) {
        if (debug) {
            Class<?> aClass = ip.getMember().getDeclaringClass();
            Logger logger = Logger.getLogger(aClass.getName());
            return new DelegatingLogger(logger);
        } else {
            return new DevNullLogger();
        }
    }
}
