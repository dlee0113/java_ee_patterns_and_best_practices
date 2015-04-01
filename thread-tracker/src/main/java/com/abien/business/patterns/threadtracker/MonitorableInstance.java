package com.abien.business.patterns.threadtracker;

import java.lang.annotation.Annotation;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class MonitorableInstance implements Monitorable{

    @Override
    public Class<? extends Annotation> annotationType() {
        return Monitorable.class;
    }
}
