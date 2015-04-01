package com.javaone.coolparts;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class APlugin implements PluginInterface{

    @Override
    public String getSomethingConfigurable() {
        return "APlugin";
    }
    
}
