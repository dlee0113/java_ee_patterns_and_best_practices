/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.twitterng.business.messaging.boundary;

import de.twitterng.messaging.entity.Tweet;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.event.Event;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class TwitterServiceTest {

    @Test
    public void tweet() throws Exception {
        TwitterService service = new TwitterService();
        service.event = mock(Event.class);
        service.em = mock(EntityManager.class);
        Tweet expected = new Tweet();
        service.tweet(expected);
        verify(service.event,times(1)).fire(expected); 
        verify(service.em,times(1)).persist(expected); 
    }
    
    @Test
    public void all() throws Exception{
        TwitterService service = spy(new TwitterService());
        List<Tweet> tweet = new ArrayList<Tweet>();
        doReturn(tweet).when(service).all();
        List<Tweet> all = service.all();
        assertSame(tweet,all);
                
        
    }


}