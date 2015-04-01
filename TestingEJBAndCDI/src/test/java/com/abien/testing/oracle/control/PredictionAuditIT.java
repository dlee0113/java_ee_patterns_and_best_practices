package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Prediction;
import com.abien.testing.oracle.entity.Result;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class PredictionAuditIT {
    
    private PredictionAudit cut;
    private EntityTransaction transaction;
    
    @Before
    public void initializeDependencies(){
        cut = new PredictionAudit();
        cut.em = Persistence.createEntityManagerFactory("integration").createEntityManager();
        this.transaction = cut.em.getTransaction();
    }
    
    
    @Test
    public void savingSuccessfulPrediction(){
        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, true);
        transaction.begin();
        this.cut.onSuccessfulPrediction(expectedResult);
        transaction.commit();
        List<Prediction> allPredictions = this.cut.allPredictions();
        assertNotNull(allPredictions);
        assertThat(allPredictions.size(),is(1));
    }

    @Test
    public void savingRolledBackPrediction(){
        final Result expectedResult = Result.BRIGHT;
        Prediction expected = new Prediction(expectedResult, false);
        this.cut.onFailedPrediction(expectedResult);
    }
    

}
