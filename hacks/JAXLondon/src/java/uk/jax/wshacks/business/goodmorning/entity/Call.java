/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author abien
 */
@IsDuke(expectedNumber=6)
@Entity
@Table(name="T_CALL")
public class Call {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Size(min=1,max=5)
    private String name;
    
    @Min(1)
    @Column(name="c_time")
    private long time;
    
    @Version
    private long version;

    public Call() {
    }

    public Call(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    
    
}
