package com.abien.business.patterns.loggerinjector.boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;

/**
 * @author blog.adam-bien.com
 */
@Alternative
public class DevNullLogger implements Log {


    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public void info(String msg) {
    }
}
