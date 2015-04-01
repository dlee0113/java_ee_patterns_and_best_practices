package com.abien.messageme.presentation;

import com.abien.messageme.business.messaging.entity.Message;
import javax.annotation.PostConstruct;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@View
public class IndexView {

    private Message message = new Message();

    public Message getMessage() {
        return message;
    }

}
