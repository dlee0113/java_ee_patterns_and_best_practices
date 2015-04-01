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

* Copyright (c) 03. March 2012 Adam Bien, adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.boundarypattern.bookstore.boundary;

import com.abien.patterns.business.Boundary;
import com.abien.patterns.business.boundarypattern.bookstore.control.Delivery;
import com.abien.patterns.business.boundarypattern.bookstore.entity.Book;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Validator;

@Stateless
@Boundary(documentationLink="http://blog.adam-bien.com",responsibility="selling books")
public class BookOrdering{

    @PersistenceContext
    EntityManager em;

    @Inject
    Delivery delivery;
    
    @Inject
    Validator validator;
    
    @Asynchronous
    public void order(Book book) {
        if(validator.validate(book, new Class[]{}).size() > 0){
            throw new IllegalArgumentException("Invalid book: " + book);
        }
        this.em.persist(book);
        delivery.deliver(book.getIsbn());
    }

    public void cancelOrder(String id) {
    }
}
