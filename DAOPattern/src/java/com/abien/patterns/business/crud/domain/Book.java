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
package com.abien.patterns.business.crud.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author adam-bien.com
 */
@Entity
@NamedQueries({
@NamedQuery(name=Book.ALL,query="Select b From Book b"),
@NamedQuery(name=Book.BY_NAME,query="Select b From Book b where b.name = :name"),
@NamedQuery(name=Book.BY_NAME_AND_PAGES,query="Select b From Book b where b.name = :name and b.numberOfPages =:pages"),
@NamedQuery(name=Book.ALL_DTO,query="Select new com.abien.patterns.business.crud.domain.BookDTO(b.numberOfPages,b.name) From Book b")
})
public class Book implements Serializable{

    public final static String ALL = "com.abien.patterns.business.crud.domain.Book.ALL";
    public final static String ALL_DTO = "com.abien.patterns.business.crud.domain.Book.ALL_DTO";
    public final static String BY_NAME = "com.abien.patterns.business.crud.domain.Book.BY_NAME";
    public final static String BY_NAME_AND_PAGES = "com.abien.patterns.business.crud.domain.Book.BY_NAME_AND_PAGES";
    @Id
    private String isbn;
    private String name;
    private int numberOfPages;

    public Book() {
    }

    public Book(String isbn,String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public Book(String isbn, String name, int numberOfPages) {
        this(isbn,name);
        this.numberOfPages = numberOfPages;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }



     @Override
    public String toString() {
        return "com.abien.samples.di.persistence.Book[isbn=" + isbn + "]";
    }

}
