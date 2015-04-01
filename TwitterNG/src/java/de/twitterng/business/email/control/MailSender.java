package de.twitterng.business.email.control;

import de.twitterng.messaging.entity.Tweet;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class MailSender {
    
    
    public void send(Tweet tweet){
        System.out.println("Tweet " + tweet);
    }

}
