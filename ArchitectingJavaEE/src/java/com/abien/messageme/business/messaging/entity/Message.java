package com.abien.messageme.business.messaging.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    private long id;
    @Size(min=2,max=140)
    private String content;

    public Message(String content) {
        this.content = content;
    }
    public Message() { /*required by JPA */}
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getId() {
        return id;
    }
}
