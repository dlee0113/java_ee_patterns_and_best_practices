package com.abien.patterns.business.aspects.cache.control;

/**
 *
 * @author adam bien, adam-bien.com
 */
public interface Cache {
    void cache(String key,Object value);
    Object fetch(String key);
}
