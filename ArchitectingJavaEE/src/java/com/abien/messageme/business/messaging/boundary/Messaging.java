package com.abien.messageme.business.messaging.boundary;

import com.abien.messageme.business.messaging.control.MessageStore;
import com.abien.messageme.business.messaging.entity.Message;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class Messaging {

    @Inject
    MessageStore messageStore;

    @Asynchronous
    public void store(Message message){
        messageStore.store(message);
    }
}
