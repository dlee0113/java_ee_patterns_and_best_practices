package com.abien.testing.configuration.boundary;

import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Configurable {

    @Inject
    private String shouldNotExist;

    @Inject
    private String javaIsDeadError;

    public String getShouldNotExist() {
        return shouldNotExist;
    }

    public String getJavaIsDeadError() {
        return javaIsDeadError;
    }
}
