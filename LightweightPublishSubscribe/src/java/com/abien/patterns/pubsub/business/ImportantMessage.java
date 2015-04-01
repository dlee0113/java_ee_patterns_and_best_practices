package com.abien.patterns.pubsub.business;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class ImportantMessage {
    
    private String message;

    public ImportantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
