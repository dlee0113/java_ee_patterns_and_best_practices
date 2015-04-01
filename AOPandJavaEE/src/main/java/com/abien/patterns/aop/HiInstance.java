package com.abien.patterns.aop;

import com.abien.patterns.aop.interceptors.Hi;
import java.lang.annotation.Annotation;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class HiInstance implements Hi{

    @Override
    public Class<? extends Annotation> annotationType() {
        return Hi.class;
    }
}
