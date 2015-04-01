package ro.dracula.business.order.control;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import ro.dracula.business.order.entity.FireFluid;

public class PoliceDepartment {


    public void onPalincaArrival(@Observes(during=TransactionPhase.AFTER_SUCCESS) FireFluid fireFluid){
        System.out.println("--- Hey arrived (police)! : " + fireFluid);
    }
}
