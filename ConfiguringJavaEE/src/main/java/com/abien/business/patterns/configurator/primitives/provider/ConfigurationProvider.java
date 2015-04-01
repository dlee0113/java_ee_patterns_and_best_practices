package com.abien.business.patterns.configurator.primitives.provider;

import java.util.Map;

/**
 *
 * @author blog.adam-bien.com
 */
public interface ConfigurationProvider {
    
    public Map<String,String> getConfiguration();

}
