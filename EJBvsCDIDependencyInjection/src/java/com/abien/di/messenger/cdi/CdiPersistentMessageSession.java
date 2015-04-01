package com.abien.di.messenger.cdi;

import com.abien.di.messenger.MessageSession;
import java.util.Date;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Session(Session.Type.PERSISTENT)
public class CdiPersistentMessageSession implements MessageSession{

    @Override
    public String getReceivedMessage() {
        return "From CDI persistent. Received at: " + new Date();
    }
}
