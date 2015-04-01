package com.abien.patterns.business.aspects.cache.control;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD})
public @interface Shared {
}
