/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

* Copyright (c) 16. February 2010 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.cdi.events.control;

import com.abien.patterns.business.cdi.events.boundary.HelloEvent;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

/**
 *
 * @author abien-bien.com
 */
@ConversationScoped
public class HelloFirstListener implements Serializable{

    private static AtomicInteger instanceCounter = new AtomicInteger();
    private HelloEvent helloEvent;

    @Inject
    Conversation conversation;

    @PostConstruct
    public void initialize(){
        System.out.println("New instance: " + instanceCounter.incrementAndGet());
    }


    public void conversationBegin(){
        this.conversation.begin();
    }

    public void conversationEnd(){
        this.conversation.end();
    }

    public void listenToHelloOne(@Observes HelloEvent helloEvent){
        System.out.println("HellHelloFirstListener: " + helloEvent + " instance: " + instanceCounter.get());
        this.helloEvent = helloEvent;
    }

    public String getEvent() {
        if(helloEvent == null)
            return "No Event";
        return this.helloEvent.toString() + " instance: " + instanceCounter.intValue();
    }
}
