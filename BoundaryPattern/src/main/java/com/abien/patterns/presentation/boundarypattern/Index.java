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

* Copyright (c) 03.03.2012, Adam Bien, adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.presentation.boundarypattern;

import com.abien.patterns.business.boundarypattern.bookstore.boundary.BookOrdering;
import com.abien.patterns.business.boundarypattern.bookstore.entity.Book;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    @Inject
    BookOrdering bo;
    
    private Book book;
    
    @PostConstruct
    public void init(){
        this.book = new Book();
    }

    public Book getBook() {
        return book;
    }
    
    public Object save(){
        bo.order(book);
        return null;
    }
}
