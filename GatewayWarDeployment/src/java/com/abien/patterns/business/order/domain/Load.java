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

* Copyright (c) 18. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.order.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author adam-bien.com
 */
@Entity
public class Load {

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Id
    @GeneratedValue
    private Long id;

    protected Load() {
        this.orderItems = new ArrayList<OrderItem>();
    }

    public static class Builder {

        private Load load;

        public Builder() {
            this.load = new Load();
        }

        public Builder withBulkyItem(int weight) {
            this.load.add(new BulkyItem(weight));
            return this;
        }

        public Builder withStandardItem(int weight) {
            this.load.add(new StandardItem(weight));
            return this;
        }

        public Builder withLightweightItem(int weight) {
            this.load.add(new LightweightItem(weight));
            return this;
        }

        public Load build() {
            if (load.orderItems.size() == 0) {
                throw new IllegalStateException("Cannot create Load without items");
            }
            return this.load;
        }
    }

    void add(OrderItem item) {
        this.orderItems.add(item);
    }

    public int getShippingCosts() {
        int shippingCosts = 0;
        for (OrderItem orderItem : orderItems) {
            shippingCosts += orderItem.getShippingCost();
        }
        return shippingCosts;
    }

    public OrderItem lightest(){
      if(this.orderItems == null || this.orderItems.size() == 0)
            return null;
       Collections.sort(this.orderItems, new WeightComparator());
       return this.orderItems.iterator().next();
    }

    public OrderItem heaviest(){
      if(this.orderItems == null || this.orderItems.size() == 0)
            return null;
       Collections.sort(this.orderItems, new WeightComparator());
       Collections.reverse(orderItems);
       return this.orderItems.iterator().next();
    }

    public OrderItem dropHeaviest(){
        OrderItem heaviest = heaviest();
        if(heaviest != null)
            drop(heaviest);
        return heaviest;
    }

    public OrderItem dropLightest(){
        OrderItem lightest = lightest();
        if(lightest != null)
            drop(lightest);
        return lightest;
    }

    public Load drop(OrderItem orderItem){
        this.orderItems.remove(orderItem);
        return this;
    }
    public Long getId() {
        return id;
    }

    public int getNumberOfOrderItems(){
        return this.orderItems.size();
    }
}
