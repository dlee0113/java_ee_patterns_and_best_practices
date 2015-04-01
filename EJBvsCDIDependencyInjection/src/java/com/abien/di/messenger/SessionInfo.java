package com.abien.di.messenger;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Named
@SessionScoped
public class SessionInfo implements Serializable{
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
