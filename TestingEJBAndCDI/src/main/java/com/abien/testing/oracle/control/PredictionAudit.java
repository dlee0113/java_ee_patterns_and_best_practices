package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Prediction;
import com.abien.testing.oracle.entity.Result;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class PredictionAudit {
    
    @PersistenceContext
    EntityManager em;
    
    public void onSuccessfulPrediction(@Observes(during= TransactionPhase.AFTER_SUCCESS) Result result){
        persistDecision(result,true);
    }

    public void onFailedPrediction(@Observes(during= TransactionPhase.AFTER_FAILURE) Result result){
        persistDecision(result,false);
    }

    void persistDecision(Result result,boolean success) {
        Prediction decision = new Prediction(result,success);
        em.persist(decision);
    }
    
    public List<Prediction> allPredictions(){
        return this.em.createNamedQuery(Prediction.findAll).getResultList();
    }
}
