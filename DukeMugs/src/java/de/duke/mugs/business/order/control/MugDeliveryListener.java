package de.duke.mugs.business.order.control;

import de.duke.mugs.business.order.entity.DukeMug;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Stateless
public class MugDeliveryListener {

    @Resource
    SessionContext sc;

    @Inject
    Mailer mail;

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<String> onGoodQuestion(@Observes @Question(Question.Quality.GOOD) DukeMug dukeMug){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            //cannot sleep
        }

        System.out.println("---Got good question: " + dukeMug + " " + sc.getCallerPrincipal());
        return new AsyncResult<String>("Done");
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<String> onGoodBadQuestion(@Observes @Question(Question.Quality.BAD) DukeMug dukeMug){
        mail.sendMail();
        System.out.println("---Got bad question: " + dukeMug + " " + sc.getCallerPrincipal());
        return new AsyncResult<String>("Done");
    }
    
}
