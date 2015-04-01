package de.twitterng.messaging.entity;

import de.twitterng.business.messaging.entity.ValidTweet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@NamedQueries({
    @NamedQuery(name=Tweet.findAll,query="Select t from Tweet t")
})
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tweet {
    
    @Id
    @GeneratedValue
    @XmlTransient
    private long id;
    
    public static final String PREFIX = "de.twitterng.messaging.entity.Tweet.";
    public static final String findAll = PREFIX + "findAll";

    //@ValidTweet(expected="java")
    private String message;

    public Tweet(String message) {
        this.message = message;
    }

    public Tweet() {
    }

    public long getId() {
        return id;
    }
    
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tweet{" + "id=" + id + ", message=" + message + '}';
    }
    
    
    

}
