
package com.abien.patterns.business.sf.soa;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

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

* Copyright (c) 16. June 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
@Stateless
public class BookMessageSenderBean implements BookMessageSenderLocal {
    @Resource(name = "jms/ServiceFacade")
    private Queue serviceFacade;
    @Resource(name = "jms/ServiceFacadeFactory")
    private ConnectionFactory serviceFacadeFactory;
    
    
   public void order(boolean sendAsText,String isbn,String name){
       OrderDTO orderVO = new OrderDTO(isbn, name);
        try {
            this.sendJMSMessageToServiceFacade(sendAsText,orderVO);
        } catch (JMSException ex) {
            Logger.getLogger(BookMessageSenderBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Cannot send message: " +ex,ex);
        }
   }

    private Message createJMSMessageForjmsServiceFacade(boolean sendAsText,Session session, OrderDTO orderVO) throws JMSException {
        if(sendAsText)
            return session.createTextMessage(orderVO.getIsbn() + " " + orderVO.getName());
        else
            return session.createObjectMessage(orderVO);
    }

    private void sendJMSMessageToServiceFacade(boolean sendAsText,OrderDTO messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = serviceFacadeFactory.createConnection();
            session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(serviceFacade);
            messageProducer.send(createJMSMessageForjmsServiceFacade(sendAsText,session, messageData));
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
 
}
