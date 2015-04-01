package com.abien.nointerfaces.control;

import com.abien.nointerfaces.entity.Message;
import java.util.List;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public interface Communicator {

    List<Message> getRecentMessages();
    
}
