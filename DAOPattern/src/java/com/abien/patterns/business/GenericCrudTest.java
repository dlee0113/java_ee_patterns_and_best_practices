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

* Copyright (c) 22. June 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business;

import com.abien.patterns.business.crud.domain.Book;
import com.abien.patterns.business.crud.CrudService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.abien.patterns.business.crud.QueryParameter.*;

/**
 *
 * @author blog.adam-bien.com
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GenericCrudTest {

    @EJB
    private CrudService crudService;
    private static final String NEW_LINE ="<br/>";


    public String crudBook(String isbn,String name){
        StringBuilder builder = new StringBuilder();
        Book book = new Book(isbn, name);
        this.crudService.create(book);
        builder.append("Book created: " + book).append(NEW_LINE);
        int size = this.crudService.findWithNamedQuery(Book.ALL).size();
        builder.append("findAll returns " + size + " books !").append(NEW_LINE);
        String newName = name + "[u]";
        book.setName(newName);

        builder.append("updating book").append(NEW_LINE);
        book = this.crudService.update(book);
        size = this.crudService.findWithNamedQuery(Book.BY_NAME,
                with("name", newName).
                parameters()).
                size();
        builder.append("findAllByName returns " + size + " books !").append(NEW_LINE);

        builder.append("deleting book").append(NEW_LINE);
        this.crudService.delete(book.getClass(),book.getIsbn());

        size = this.crudService.findWithNamedQuery(Book.ALL).size();
        builder.append("findAll returns " + size + " books !").append(NEW_LINE);
        return builder.toString();
    }
}
