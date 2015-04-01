package com.abien.business.patterns.templateplugin;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    Greeter greeter;
    
    @Inject
    Messenger messenger;
    
    private String content;
    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getMessage(){
        return greeter.getGreetings();
    }
    
    public Object sendMessage(){
        messenger.sendMessage(this.content);
        return null;
    }
}
