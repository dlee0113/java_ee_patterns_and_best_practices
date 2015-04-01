package com.abien.business.patterns.configurator.primitives.provider;

import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
public class FacesConfigurationProvider implements ConfigurationProvider{

    @Inject
    private Map<String,String> servletInitParameters;
    
    @Override
    public Map<String, String> getConfiguration() {
        return servletInitParameters;
    }
}
