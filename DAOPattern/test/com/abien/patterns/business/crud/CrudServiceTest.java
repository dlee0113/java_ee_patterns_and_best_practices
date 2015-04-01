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
package com.abien.patterns.business.crud;

import com.abien.patterns.business.crud.domain.Book;
import com.abien.patterns.business.crud.domain.BookDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.abien.patterns.business.crud.QueryParameter.*;

/**
 *
 * @author adam-bien.com
 */
public class CrudServiceTest {

    private EntityManager em;
    private EntityTransaction et;
    private CrudService crudServiceBean;

    @Before
    public void setUp() throws Exception {
        this.em = Persistence.createEntityManagerFactory("test").createEntityManager();
        this.et = this.em.getTransaction();
        this.crudServiceBean = new CrudService();
        this.crudServiceBean.em = this.em;
    }
    
    @Test
    public void crud(){
        Book book = new Book("1", "Productive Java EE");

        this.et.begin();

        int initialSize = this.crudServiceBean.findWithNamedQuery(Book.ALL).size();

        //create
        Book created = (Book) this.crudServiceBean.create(book);
        assertNotNull(created);
        assertEquals(book.getIsbn(),created.getIsbn());
        assertEquals(book.getName(),created.getName());
        Book found = this.crudServiceBean.find(Book.class,created.getIsbn());
        assertNotNull(found);
        assertEquals(found.getIsbn(),created.getIsbn());

        //query
        int size = this.crudServiceBean.findWithNamedQuery(Book.ALL).size();
        assertEquals(initialSize+1,size);

        String newName = book.getName() + " Second Edition";
        book.setName(newName);
        //update
        Book updated = (Book) this.crudServiceBean.update(book);
        assertNotNull(updated);

        Book foundUpdated = this.crudServiceBean.find(Book.class,created.getIsbn());
        assertNotNull(foundUpdated);
        assertEquals(updated.getName(),foundUpdated.getName());

        //delete
        this.crudServiceBean.delete(foundUpdated.getClass(),foundUpdated.getIsbn());

        Book shouldntExist = this.crudServiceBean.find(Book.class,created.getIsbn());
        assertNull(shouldntExist);

        int zero = this.crudServiceBean.findWithNamedQuery(Book.ALL).size();
        assertEquals(0,zero);

        this.et.rollback();
    }
    
    @Test
    public void findByName(){
        Book book = new Book("1", "Java",200);
        this.et.begin();

        //create
        Book created =  this.crudServiceBean.create(book);

        assertNotNull(created);
        assertEquals(book.getIsbn(),created.getIsbn());
        assertEquals(book.getName(),created.getName());
        assertEquals(book.getNumberOfPages(),created.getNumberOfPages());

        
        int size = this.crudServiceBean.findWithNamedQuery(Book.BY_NAME_AND_PAGES,
                with("name",book.getName()).
                and("pages", book.getNumberOfPages()).
                parameters()).
                size();
        assertEquals(1,size);

        size = this.crudServiceBean.findWithNamedQuery(Book.BY_NAME_AND_PAGES,
                with("name",book.getName()).
                and("pages", book.getNumberOfPages() -1).
                parameters()).
                size();
        assertEquals(0,size);

        this.et.rollback();
    }
    @Test
    public void findAllReturnDTO(){
        Book book = new Book("1", "Java",200);
        this.et.begin();
        //create
        Book created = (Book) this.crudServiceBean.create(book);
        assertNotNull(created);
        assertEquals(book.getIsbn(),created.getIsbn());
        assertEquals(book.getName(),created.getName());
        assertEquals(book.getNumberOfPages(),created.getNumberOfPages());
        
        List<BookDTO> dtos = this.crudServiceBean.findWithNamedQuery(Book.ALL_DTO);
        boolean found = false;
        for (BookDTO bookDTO : dtos) {
            if(bookDTO.getName().equals(created.getName()) && bookDTO.getNumberOfPages() == created.getNumberOfPages())
                found = true;
        }
        assertTrue(found);
        this.et.rollback();
    }    
}