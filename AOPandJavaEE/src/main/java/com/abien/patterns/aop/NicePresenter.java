package com.abien.patterns.aop;

import com.abien.patterns.aop.interceptors.Nice;
import static com.abien.patterns.aop.interceptors.Nice.Level.PERSONAL;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Stereotype;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Model
@Nice(PERSONAL)
@Stereotype
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NicePresenter {}
