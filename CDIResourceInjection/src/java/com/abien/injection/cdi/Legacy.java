package com.abien.injection.cdi;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author blog.adam-bien.com
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, TYPE})
public @interface Legacy {
}