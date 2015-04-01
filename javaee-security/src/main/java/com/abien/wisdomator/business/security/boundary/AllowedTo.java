package com.abien.wisdomator.business.security.boundary;

import com.abien.wisdomator.business.security.entity.Permission;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author adam-bien.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedTo {
    Permission[] value();
}
