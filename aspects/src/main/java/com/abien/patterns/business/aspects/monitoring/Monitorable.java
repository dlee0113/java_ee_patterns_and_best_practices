package com.abien.patterns.business.aspects.monitoring;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE})
public @interface Monitorable {
}
