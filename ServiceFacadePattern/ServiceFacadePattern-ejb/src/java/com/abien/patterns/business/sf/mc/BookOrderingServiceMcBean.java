package com.abien.patterns.business.sf.mc;

import com.abien.patterns.business.sf.soa.NotNull;
import com.abien.patterns.business.sf.soa.PreconditionInterceptor;
import javax.ejb.Remote;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
@Stateless
@Local(BookOrderingServiceLocal.class)
@Remote(BookOrderingServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@WebService //for test purposes only
public class BookOrderingServiceMcBean implements BookOrderingServiceLocal {

    public void order(String isbn, @WebParam(name="orderName") String name) {
        System.out.println("order ISBN: " + isbn + " name: " + name);
    }

    public void cancelOrder(String id) {
        System.out.println("cancelOrder " + id);
    }

    public Object referenceTest(Object reference) {
       return reference;
    }


 
}
