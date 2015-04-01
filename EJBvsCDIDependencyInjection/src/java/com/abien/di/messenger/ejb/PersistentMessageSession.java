package com.abien.di.messenger.ejb;

import com.abien.di.messenger.MessageSession;
import java.util.Date;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
//@Stateless
//@Local(MessageSession.class)
public class PersistentMessageSession implements MessageSession{

    @Override
    public String getReceivedMessage() {
        return "From persistent. Received at: " + new Date();
    }

}
