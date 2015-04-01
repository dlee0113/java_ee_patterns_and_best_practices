package ro.dracula.presentation.palincie;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.validation.constraints.Size;
import ro.dracula.business.order.boundary.PalincaComanderService;
import ro.dracula.business.order.entity.FireFluid;

@ViewBean
public class Index {

    @EJB
    PalincaComanderService pcs;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getHello(){
        return "Servus " + new Date() +  pcs.order(5);
    }

    public List<FireFluid> getFireFluids(){
        return pcs.all(name);
    }
}
