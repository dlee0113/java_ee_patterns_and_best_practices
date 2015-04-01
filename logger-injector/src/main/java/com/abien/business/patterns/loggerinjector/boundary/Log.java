package com.abien.business.patterns.loggerinjector.boundary;

import java.util.logging.Logger;

/**
 *
 * @author blog.adam-bien.com
 */
public interface Log {

    public Logger getLogger();

    public void info(String msg);

}
