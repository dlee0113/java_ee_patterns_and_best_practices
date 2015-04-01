/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien.patters.serviceactivator.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@MessageDriven(mappedName = "jms/serviceactivator", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ServiceActivator implements MessageListener {

    @Inject
    SynchronousService service;
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                String text = textMessage.getText();
                service.message(text);
            } catch (JMSException ex) {
                throw new EJBException("Cannot extract payload: " + ex,ex);
            }
        }else{
            throw new EJBException("TextMessage expected but was: " + message);
        }
    }
}
