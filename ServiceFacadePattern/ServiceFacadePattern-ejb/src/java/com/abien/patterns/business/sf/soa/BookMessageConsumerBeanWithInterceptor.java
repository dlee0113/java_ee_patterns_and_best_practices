package com.abien.patterns.business.sf.soa;

import com.abien.patterns.business.sf.BookOrderingServiceLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

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
@MessageDriven(mappedName = "jms/ServiceFacade", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
@Interceptors(MessageTypeCheckInterceptor.class)
public class BookMessageConsumerBeanWithInterceptor implements MessageListener {
    
    @EJB
    private BookOrderingServiceLocal bookOrderingServiceLocal;

    @ExpectedMessageType(ObjectMessage.class)
    public void onMessage(Message message) {
            try {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Serializable payload = objectMessage.getObject();
                if (payload instanceof OrderDTO) {
                    OrderDTO orderVO = (OrderDTO) payload;
                    String name = orderVO.getName();
                    String isbn = orderVO.getIsbn();
                    this.bookOrderingServiceLocal.order(isbn, name);
                } else {
                    handleError("Payload is not a OrderVO", payload);
                }
            } catch (JMSException ex) {
                throw new IllegalStateException("Cannot consume message: " + message,ex);
            }
        
        
    }

    private void handleError(String string, Object payload) {
        throw new IllegalStateException(string + " " + payload.getClass() + " JMS Message " + payload);
    }
}
