package com.abien.business.patterns.plugin.testapp.boundary;

import com.abien.business.patterns.plugin.serializer.Serializer;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class Plugins {

    @Inject
    Instance<Serializer> plugins;

    public String discoverPlugins() {
        System.out.println("");
        String retVal = "";
        for (Serializer plugin : plugins) {
            retVal += plugin.getClass().getName();
        }
        return retVal;
    }
}
