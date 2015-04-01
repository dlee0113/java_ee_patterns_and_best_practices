package com.abien.nointerfaces.control;

import com.abien.nointerfaces.entity.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Confidentiality(Confidentiality.Level.STRONG)
public class ConfidentialCommunicator implements Communicator {

    @Override
    public List<Message> getRecentMessages(){
        return new ArrayList<Message>(){{
            add(new Message("top secret"));
        }};
    }
}
