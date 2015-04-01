package de.duke.mugs.presentation;

import de.duke.mugs.business.order.DukeMugOrderingService;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Index {

    @EJB
    DukeMugOrderingService ordering;

    public String getHello(){
        return "Hello duke " + new Date() + ordering.helloDuke();
    }
}
