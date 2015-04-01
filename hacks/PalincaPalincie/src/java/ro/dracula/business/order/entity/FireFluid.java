package ro.dracula.business.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@NamedQuery(name="findall",query="Select f from FireFluid f where f.name like :name")
public class FireFluid {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int amount;

    public FireFluid() {
    }

    public FireFluid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FireFluid{" + "id=" + id + "name=" + name + '}';
    }

    public int getAmount() {
        return amount;
    }


    

}
