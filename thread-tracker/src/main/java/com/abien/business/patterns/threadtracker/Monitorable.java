package com.abien.business.patterns.threadtracker;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE})
public @interface Monitorable {}
