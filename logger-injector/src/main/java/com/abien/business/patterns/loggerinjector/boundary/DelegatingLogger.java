package com.abien.business.patterns.loggerinjector.boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;

/**
 * @author blog.adam-bien.com
 */
@Alternative
public class DelegatingLogger implements Log {

    private Logger logger;

    public DelegatingLogger(Logger logger) {
        this.logger = logger;
    }

    void log(Level level, String message, Object[] params) {
        this.logger.log(level, message, params);
    }

    @Override
    public void info(String msg) {
        this.log(Level.INFO, msg, new Object[]{});
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
