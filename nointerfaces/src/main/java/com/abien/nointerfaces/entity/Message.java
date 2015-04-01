package com.abien.nointerfaces.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" + "content=" + content + '}';
    }
}
