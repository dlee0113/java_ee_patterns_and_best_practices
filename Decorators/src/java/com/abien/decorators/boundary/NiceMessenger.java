package com.abien.decorators.boundary;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class NiceMessenger implements Messenger {
    
    @Override
    public String morning(){
        return "morning";
    }
}
