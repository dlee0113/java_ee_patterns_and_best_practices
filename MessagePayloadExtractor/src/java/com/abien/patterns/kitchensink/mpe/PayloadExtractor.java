package com.abien.patterns.kitchensink.mpe;

import java.io.Serializable;
import java.lang.reflect.Method;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author adam-bien.com
 */
public class PayloadExtractor {
    public static final String CONSUME_METHOD = "consume";
    @Inject
    private DeadLetterHandler dlh;
    
    @AroundInvoke
    public Object audit(InvocationContext invocationContext) throws Exception{
        Object mdb = invocationContext.getTarget();
        Method method = invocationContext.getMethod();

        if("onMessage".equals(method.getName())){
            Message jmsMessage = (Message) messageParameter(invocationContext);
            invokeMethodWithSingleParameter(jmsMessage,mdb);
        }
          return invocationContext.proceed();
    }

    private void escalateError(Message originMessage) {
        this.dlh.wrongMessageType(originMessage);
    }

    private void invokeMethodWithSingleParameter(Message jmsMessage,Object mdb)  {
          if(jmsMessage instanceof ObjectMessage){
            try {
                ObjectMessage om = (ObjectMessage) jmsMessage;
                Serializable payload = om.getObject();
                invokeConsumeMethod(mdb, jmsMessage, payload);
            } catch (JMSException ex) {
                throw new IllegalStateException("Cannot get payload from ObjectMessage " +ex,ex);
            }
          }else if(jmsMessage instanceof TextMessage){
            try {
                TextMessage tm = (TextMessage) jmsMessage;
                String payload = tm.getText();
                invokeConsumeMethod(mdb, jmsMessage, payload);
            } catch (JMSException ex) {
                throw new IllegalStateException("Cannot get payload from TextMessage " +ex,ex);
            }
          }else{
              escalateError(jmsMessage);
          }
    }
    
    private void invokeConsumeMethod(Object mdb,Message message,Object methodParameter){
        try {
            mdb.getClass().getMethod(CONSUME_METHOD,methodParameter.getClass()).invoke(mdb, methodParameter);
        } catch (NoSuchMethodException ex) {
           escalateError(message);
        } catch (Exception ex) {
            throw new IllegalStateException("Cannot access the consume method " + ex, ex);
        }
    }

    private Object messageParameter(InvocationContext context){
        return context.getParameters()[0];
    }
}
