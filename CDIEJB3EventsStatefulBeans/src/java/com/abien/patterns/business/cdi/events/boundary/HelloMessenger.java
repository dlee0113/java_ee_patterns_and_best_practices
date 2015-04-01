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
package com.abien.patterns.business.cdi.events.boundary;

import com.abien.patterns.business.cdi.events.control.HelloFirstListener;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author abien-bien.com
 */
@Named("messenger")
@SessionScoped
public class HelloMessenger implements Serializable{

    @Inject @Any Event<HelloEvent> events;

    @Inject
    HelloFirstListener firstListener;

    @Inject
    HelloFirstListener another;
    

    public void hello(){
        events.fire(new HelloEvent("from bean " + System.currentTimeMillis()));
    }

    public String getEvent(){

        return firstListener.getEvent() + " " + another.getEvent();
    }

    public void startConversation(){
        this.firstListener.conversationBegin();
    }

    public void endConversation(){
        this.firstListener.conversationEnd();
    }



}
