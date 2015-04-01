package ro.dracula.business.order.control;

import javax.enterprise.inject.Produces;

public class PalincaCreationEngineFactory {

    @Produces
    public PalincaCreationEngine create(){
        return new PalincaCreationEngine(21);
    }

}
