package com.abien.patterns.business.sf.laf;

import com.abien.patterns.business.sf.soa.OrderDTO;
import java.util.concurrent.Future;
import javax.ejb.Local;
import javax.ejb.Stateless;

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

* Copyright (c) 16. June 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
//@Asynchronous - use it only with Java EE 6 compatible container.
@Stateless
@Local(BookOrderingService.class)
public class BookOrderingServiceLafBean implements BookOrderingService {

    public Future<OrderDTO> order(String isbn, String name) {
//        OrderVO orderVO = ...
  //      return new AsyncResult<OrderVO>(orderVO);
        return null;
    }

    public void cancelOrder(String id) {

    }
}
