package de.pizza42.presentation.order;

import de.pizza42.business.order.boundary.OrderingService;
import de.pizza42.business.order.entity.Pizza;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

@Model
//@BackingBean
public class Index {

    @EJB
    OrderingService order;

    private Pizza pizza = new Pizza();

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }



    @PostConstruct
    public void onInitialize(){
        System.out.println("on load!");
    }


    public Object save(){
        this.order.order(pizza);
        return "end";
    }

}
