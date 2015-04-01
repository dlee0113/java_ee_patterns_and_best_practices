package com.abien.testing.oracle.boundary;

import com.abien.testing.oracle.control.Blogger;
import java.util.Iterator;
import com.abien.testing.oracle.control.Consultant;
import com.abien.testing.oracle.control.ReasonableConsultant;
import com.abien.testing.oracle.entity.Result;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class OracleResourceTest {
    
    private OracleResource cut;
    
    @Before
    public void initializeDependencies(){
        this.cut = new OracleResource();
        this.cut.company = mock(Instance.class);
        this.cut.eventListener = mock(Event.class);
    }
    
    
    @Test(expected=IllegalStateException.class)
    public void checkConsultantAvailabilityWithoutConsultant(){
        when(this.cut.company.isUnsatisfied()).thenReturn(true);
        this.cut.checkConsultantAvailability();
    }

    @Test
    public void checkConsultantAvailabilityWithConsultant(){
        when(this.cut.company.isUnsatisfied()).thenReturn(false);
        this.cut.checkConsultantAvailability();
    }

    @Test(expected=IllegalStateException.class)
    public void unreasonablePrediction(){
        Consultant consultant = new Blogger();
        Iterator iterator = mockIterator(consultant);
        when(this.cut.company.iterator()).thenReturn(iterator);
        
        this.cut.predictFutureOfJava();
    }

    @Test
    public void unreasonablePredictionFiresEvent(){
        Consultant consultant = new Blogger();
        Result expectedResultToFire = consultant.predictFutureOfJava();
        Iterator iterator = mockIterator(consultant);
        when(this.cut.company.iterator()).thenReturn(iterator);
        try{
            this.cut.predictFutureOfJava();
        }catch(IllegalStateException e){}
        verify(this.cut.eventListener,times(1)).fire(expectedResultToFire);
    }

    Iterator mockIterator(Consultant consultant) {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn(consultant);
        when(iterator.hasNext()).thenReturn(true);
        return iterator;
    }

    @Test
    public void likelyPrediction(){
        Consultant consultant = new ReasonableConsultant();
        Result expectedResultToFire = consultant.predictFutureOfJava();
        Iterator iterator = mockIterator(consultant);
        when(this.cut.company.iterator()).thenReturn(iterator);
        
        String actualResult = this.cut.predictFutureOfJava();
        
        verify(this.cut.eventListener,times(1)).fire(expectedResultToFire);
        assertThat(actualResult, is(expectedResultToFire.name()));
    }
    
    @Test
    public void getConsultant(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn(null);
        when(this.cut.company.iterator()).thenReturn(iterator);
        Consultant consultant = this.cut.getConsultant();
        assertNull(consultant);
    }
}
