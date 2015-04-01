package de.oop.etrade.business.ordering.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name="t_stock")
public class Stock {

    @Id
    private String name;
    @Min(value=2,message="Please more") @Max(value=43,message="Too much")
    private float quote;

    public Stock() {
    }

    public Stock(String name, float quote) {
        this.name = name;
        this.quote = quote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuote() {
        return quote;
    }

    public void setQuote(float quote) {
        this.quote = quote;
    }



    @Override
    public String toString() {
        return "Stock{" + "name=" + name + "quote=" + quote + '}';
    }

    
}
