package com.abien.testing.oracle.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name=Prediction.findAll,query="Select d from Prediction d")
public class Prediction {
    
    public final static String PREFIX = "com.abien.testing.oracle.entity.Prediction.";
    public final static String findAll = PREFIX + "findAll";

    @Id
    @GeneratedValue
    @XmlTransient
    private long id;
    
    @Column(name="prediction_result")
    @Enumerated(EnumType.STRING)
    private Result result;
    
    @Temporal(TemporalType.TIME)
    private Date predictionDate;
    
    private boolean success;

    public Prediction() {
        this.predictionDate = new Date();
    }
    
    public Prediction(Result result, boolean success) {
        this();
        this.result = result;
        this.success = success;
    }

    public Date getPredictionDate() {
        return predictionDate;
    }

    public Result getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prediction other = (Prediction) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.result != other.result) {
            return false;
        }
        if (this.predictionDate != other.predictionDate && (this.predictionDate == null || !this.predictionDate.equals(other.predictionDate))) {
            return false;
        }
        if (this.success != other.success) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + (this.result != null ? this.result.hashCode() : 0);
        hash = 71 * hash + (this.predictionDate != null ? this.predictionDate.hashCode() : 0);
        hash = 71 * hash + (this.success ? 1 : 0);
        return hash;
    }
    
    

    @Override
    public String toString() {
        return "Decision{" + "result=" + result + ", predictionDate=" + predictionDate + ", success=" + success + '}';
    }
}
