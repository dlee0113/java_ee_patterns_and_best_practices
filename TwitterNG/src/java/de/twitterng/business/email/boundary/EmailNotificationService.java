package de.twitterng.business.email.boundary;

import de.twitterng.business.email.control.MailSender;
import de.twitterng.messaging.entity.Tweet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class EmailNotificationService {
    private ConcurrentHashMap<Long,Tweet> store = new ConcurrentHashMap<Long, Tweet>();
    
    @Inject
    MailSender sender;
    
    @Asynchronous
    public void onTweet(@Observes(during=TransactionPhase.AFTER_SUCCESS) Tweet tweet){
        store.put(tweet.getId(), tweet);
    }
    
    
    @Schedule(second="*/5",minute="*",hour="*")
    public void sendMails(){
        System.out.println("store: " + store);
        Set<Entry<Long, Tweet>> entrySet = store.entrySet();
        for (Entry<Long, Tweet> entry : entrySet) {
            sender.send(entry.getValue());
        }
        store.clear();
    }

}
