package com.abien.patters.serviceactivator.presentation;

import com.abien.patters.serviceactivator.business.ServiceClient;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    ServiceClient client;
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public Object send(){
        this.client.broadcast(message);
        return null;
    }
    
}
