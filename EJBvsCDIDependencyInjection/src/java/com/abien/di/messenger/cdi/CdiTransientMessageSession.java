package com.abien.di.messenger.cdi;

import com.abien.di.messenger.MessageSession;
import java.util.Date;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Session(Session.Type.TRANSIENT)
public class CdiTransientMessageSession implements MessageSession {

    @Override
    public String getReceivedMessage() {
        return "From CDI transient. Received at: " + new Date();
    }
}
