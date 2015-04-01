package com.abien.patterns.business.boundarypattern.bookstore.boundary;

import com.abien.patterns.business.boundarypattern.bookstore.control.Delivery;
import com.abien.patterns.business.boundarypattern.bookstore.entity.Book;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class BookOrderingTest {
    BookOrdering cut;
    
    @Before
    public void injectDependencies(){
        this.cut = new BookOrdering();
        this.cut.delivery = mock(Delivery.class);
        this.cut.em = mock(EntityManager.class);
    }

    @Test
    public void order() {
        Book book = new Book("4", "Night Hacks");
        this.cut.order(book);
        verify(this.cut.em,times(1)).persist(book);
        verify(this.cut.delivery,times(1)).deliver(book.getIsbn());
    }
}
