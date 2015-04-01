package com.abien.patterns.presentation.order;

import com.abien.patterns.business.order.domain.Load;
import com.abien.patterns.business.order.facade.OrderGateway;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="load")
@SessionScoped
public class LoadView {

    @EJB
    OrderGateway orderGateway;

    protected Long loadId;

    private int lightWeight;
    private int standardWeight;
    private int bulkyWeight;

    public Long getLoadId() {
        return loadId;
    }

    public int getBulkyWeight() {
        return bulkyWeight;
    }

    public void setBulkyWeight(int bulkyWeight) {
        this.bulkyWeight = bulkyWeight;
    }

    public int getLightWeight() {
        return lightWeight;
    }

    public void setLightWeight(int lightWeight) {
        this.lightWeight = lightWeight;
    }

    public int getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(int standardWeight) {
        this.standardWeight = standardWeight;
    }

    public int getShippingCost(){
        Load current = this.getLoad();
        if(current == null)
            return 0;
        else
            return current.getShippingCosts();
    }

    public void dropLightest(){
       Load load = getLoad();
       if(load != null)
          load.dropLightest();
    }

    public void dropHeaviest(){
       Load load = getLoad();
       if(load != null)
            load.dropHeaviest();
    }

    private Load getLoad(){
        return this.orderGateway.getCurrent();
    }

    public boolean isEmptyLoad(){
        return (getNumberOfItems() <= 0);
    }
    public int getNumberOfItems(){
        Load current = this.getLoad();
        if(current == null)
            return 0;
        else
            return current.getNumberOfOrderItems();
    }

     
    public void createLoad() {
        Load load = new Load.Builder().
                withStandardItem(this.standardWeight).
                withLightweightItem(this.lightWeight).
                withBulkyItem(this.bulkyWeight).
                build();

        orderGateway.create(load);
        orderGateway.save();
        this.loadId = load.getId();
    }

}

