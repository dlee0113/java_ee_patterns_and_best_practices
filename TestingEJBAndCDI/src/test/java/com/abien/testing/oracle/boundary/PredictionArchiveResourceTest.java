package com.abien.testing.oracle.boundary;

import com.abien.testing.oracle.entity.Prediction;
import java.util.List;
import com.abien.testing.oracle.control.PredictionAudit;
import com.abien.testing.oracle.entity.Result;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class PredictionArchiveResourceTest {
    
    PredictionArchiveResource cut;
    
    @Before
    public void initialize(){
        this.cut = new PredictionArchiveResource();
        this.cut.audit = mock(PredictionAudit.class);
    }

    @Test
    public void allDecisionsWithMaxLesserReturn() throws Exception {
        int expectedSize = 2;
        List<Prediction> prediction = createDecisions(expectedSize);
        when(this.cut.audit.allPredictions()).thenReturn(prediction);
        
        List<Prediction> allDecisions = this.cut.allPredictions(3);
        assertThat(allDecisions.size(), is(expectedSize));
    }

    @Test
    public void allDecisionsWithMaxGreaterReturn() throws Exception {
        int max = 5;
        int expected = 3;
        List<Prediction> prediction = createDecisions(max);
        when(this.cut.audit.allPredictions()).thenReturn(prediction);
        
        List<Prediction> allDecisions = this.cut.allPredictions(expected);
        assertThat(allDecisions.size(), is(expected));
    }

    @Test
    public void allDecisionsWithMaxEqualReturn() throws Exception {
        int max = 5;
        int expected = max;
        List<Prediction> prediction = createDecisions(max);
        when(this.cut.audit.allPredictions()).thenReturn(prediction);
        
        List<Prediction> allDecisions = this.cut.allPredictions(expected);
        assertThat(allDecisions.size(), is(expected));
    }

    List<Prediction> createDecisions(final int nr) {
         return new ArrayList<Prediction>(){{
             for (int i = 0; i < nr; i++) {
                add(new Prediction(Result.BRIGHT, true));
             }
        }};
    }
}
