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

* Copyright (c) 20. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.lazy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Bien (blog.adam-bien.com)
 */
public class Master {

    private Detail detail;

    private List<Detail> details;

    public Master(Detail detail) {
        this.detail = detail;
        this.details = new ArrayList<Detail>();
        this.details.add(detail);
    }

    public Detail getDetail() {
        System.out.println("getDetail");
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
