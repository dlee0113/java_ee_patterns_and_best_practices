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

* Copyright (c) 10. November 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.business.fireandforget.boundary;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author http://blog.adam-bien.com
 */
@Path("message")
@Stateless
public class MessagingService {

    @PersistenceContext
    EntityManager em;

    @POST
    @Asynchronous
    public void newMessage(String content){
        em.persist(new Message(content));
    }

    @Asynchronous
    public Future<Long> create(String content){
        Message message = new Message(content);
        em.persist(message);
        em.flush();
        em.refresh(message);
        return new AsyncResult<Long>(message.getId());
    }
}
