/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

* Copyright (c) 12. July 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.business.orderprocessor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Adam Bien (blog.adam-bien.com)
 */
@Entity
@Table(name = "T_ORDER")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    private long id;
    @XmlElement
    private int amount;
    @XmlElement
    private int productId;
    @XmlElement
    private boolean delivered;

    public Order() {
    }

    public Order(int amount, int productId) {
        this.amount = amount;
        this.productId = productId;
    }

    public boolean isDelivered() {
        return delivered;
    }
    
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
