package de.twitterng.presentation.messaging;

import de.twitterng.business.messaging.boundary.TwitterService;
import de.twitterng.messaging.entity.Tweet;
import javax.ejb.EJB;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */

@Presenter
public class Index {
    
    @EJB
    TwitterService service;
    
    private boolean textEnabled;

    public boolean isTextEnabled() {
        return textEnabled;
    }

    public void setTextEnabled(boolean textEnabled) {
        this.textEnabled = textEnabled;
    }
    
    
    
    
    
    private Tweet tweet = new Tweet();

    public Tweet getTweet() {
        return tweet;
    }
    
    public Object saveTweet(){
        service.tweet(tweet);
        this.textEnabled = true;
        return null;
    }
}
