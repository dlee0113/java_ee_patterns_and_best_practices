package com.abien.patterns.threading;

import com.abien.patterns.threading.StopWatch;
import com.abien.patterns.threading.tasks.boundary.BatchTask;
import com.abien.patterns.threading.tasks.boundary.PersistentAsynchronous;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
@Interceptors(StopWatch.class)
public class Index {
    
    @Inject
    BatchTask bt;
    
    @Inject
    PersistentAsynchronous pa;
    
    public String invoke(){
        bt.executeBatch();
        return "+ ";
    }
    
    public String invokePersistent(){
        pa.executeAsync("from Index " + System.currentTimeMillis());
        return "+ ";
    }
}
