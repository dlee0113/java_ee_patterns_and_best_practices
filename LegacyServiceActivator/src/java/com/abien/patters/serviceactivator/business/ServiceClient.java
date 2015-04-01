package com.abien.patters.serviceactivator.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class ServiceClient {

    @Resource(mappedName = "jms/serviceactivator")
    private Queue serviceactivator;
    @Resource(mappedName = "jms/serviceactivatorFactory")
    private ConnectionFactory serviceactivatorFactory;
    
    public void broadcast(String message){
        Connection connection = null;
        Session session = null;
        try {
            connection = serviceactivatorFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(serviceactivator);
            messageProducer.send(createTextMessage(session, message));
        }catch(Exception e){
            throw new EJBException("Cannot send message: " +e,e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot close session", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, "Cannot close connection", ex);
                }
            }
        }
    }
    
    private Message createTextMessage(Session session, String messageData) throws JMSException {
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData);
        return tm;
    }
    
}
