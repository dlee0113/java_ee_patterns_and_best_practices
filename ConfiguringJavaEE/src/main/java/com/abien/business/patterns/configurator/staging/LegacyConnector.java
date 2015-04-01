package com.abien.business.patterns.configurator.staging;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
public class LegacyConnector implements EISConnector{

    @Override
    public String fetchInfo() {
        return "From Host";
    }
    
}
