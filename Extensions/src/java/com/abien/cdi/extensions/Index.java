package com.abien.cdi.extensions;

import javax.enterprise.inject.Model;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Model
public class Index {
    public String getHello(){
        return "hey joe";
    }
}
