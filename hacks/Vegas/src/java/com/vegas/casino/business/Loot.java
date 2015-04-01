package com.vegas.casino.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Loot {


    @Id
    @GeneratedValue
    private Long id;

    private int amount;

    public Loot() {
    }

    public Loot(int amount) {
        this.amount = amount;
    }

    

}
