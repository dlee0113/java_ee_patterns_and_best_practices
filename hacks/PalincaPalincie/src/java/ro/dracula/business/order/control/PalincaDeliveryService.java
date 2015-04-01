package ro.dracula.business.order.control;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class PalincaDeliveryService {


    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void deliver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PalincaDeliveryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Delivered! " + new Date());
    }
}
