package com.abien.business.patterns.bridgeplugin;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Stereotype;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Alternative
@Stereotype
@Retention(RUNTIME)
@Target({TYPE})
public @interface Standard {
}
