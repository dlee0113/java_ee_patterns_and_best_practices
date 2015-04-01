package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Prediction;
import com.abien.testing.oracle.entity.Result;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class PredictionAuditTest {
    
    private PredictionAudit cut;
    
    @Before
    public void initializeDependencies(){
        cut = new PredictionAudit();
        cut.em = mock(EntityManager.class);
    }
    
    
    @Test
    public void savingSuccessfulPrediction(){
        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, true);
        this.cut.onSuccessfulPrediction(expectedResult);
        verify(cut.em,times(1)).persist(expected);
    }

    @Test
    public void savingRolledBackPrediction(){
        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, false);
        this.cut.onFailedPrediction(expectedResult);
        verify(cut.em,times(1)).persist(expected);
    }

}
