package ro.dracula.business.order.control;

public class PalincaCreationEngine {


    private int amount;

    public PalincaCreationEngine(int amount) {
        this.amount = amount;
    }


    public int burn(){
        return amount;
    }

}
