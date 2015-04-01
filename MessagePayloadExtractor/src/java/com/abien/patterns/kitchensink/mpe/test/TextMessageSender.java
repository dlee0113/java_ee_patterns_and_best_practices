package com.abien.patterns.kitchensink.mpe.test;

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
import javax.jms.TextMessage;
import javax.jws.WebService;

/**
 *
 * @author adam-bien.com
 */
@Stateless
@WebService
public class TextMessageSender {
    @Resource(mappedName = "ajax")
    private Queue ajax;
    @Resource(mappedName = "jms/DeadLetterQueueFactory")
    private ConnectionFactory ajaxFactory;



    public void send(String send){
        try {
            this.sendJMSMessageToAjax(send);
        } catch (JMSException ex) {
            Logger.getLogger(TextMessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Message createJMSMessageForajax(Session session, String messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData);
        return tm;
    }

    private void sendJMSMessageToAjax(String messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = ajaxFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(ajax);
            messageProducer.send(createJMSMessageForajax(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
