package com.abien.patterns.kitchensink.mpe.listener;

import com.abien.patterns.kitchensink.mpe.PayloadExtractor;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author adam-bien.com
 */
@MessageDriven(mappedName = "ajax", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class MessageConsumerBean implements MessageListener {
 
    @Override
    @Interceptors(PayloadExtractor.class)
    public void onMessage(Message message) {
        /* the work is done in interceptor */
    }
    
    public void consume(String message){
        System.out.println("Payload received: " + message);
    }
}
