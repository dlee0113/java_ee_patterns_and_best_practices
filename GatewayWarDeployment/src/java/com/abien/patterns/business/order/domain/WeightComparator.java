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

import java.util.Comparator;

/**
 *
 * @author adam-bien.com
 */
public class WeightComparator implements Comparator<OrderItem>{
        public final static int FIRST_LESS = -1;
        public final static int EQUAL = 0;
        public final static int FIRST_GREATER = 1;

    public int compare(OrderItem o1, OrderItem o2) {
        if(o1.getWeight() < o2.getWeight())
            return FIRST_LESS;
        else if(o1.getWeight() > o2.getWeight())
            return FIRST_GREATER;
        else
            return EQUAL;
    }

}
