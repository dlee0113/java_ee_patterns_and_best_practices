package com.abien.nointerfaces.control;

import com.abien.nointerfaces.entity.Message;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Confidentiality(Confidentiality.Level.WEAK)
public class PublicCommunicator implements Communicator{

    @Override
    public List<Message> getRecentMessages(){
        return new ArrayList<Message>(){{
            add(new Message("first"));
            add(new Message("second"));
        }};
    }
}
