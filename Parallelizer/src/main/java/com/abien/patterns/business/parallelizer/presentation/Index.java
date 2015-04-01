package com.abien.patterns.business.parallelizer.presentation;

import com.abien.patterns.business.parallelizer.pull.boundary.PullParallelizer;
import com.abien.patterns.business.parallelizer.push.boundary.PushParallelizer;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    @Inject
    PullParallelizer pullParallelizer;

    @Inject
    PushParallelizer pushParallelizer;
    
    public List<Long> getResult(){
        return pullParallelizer.executeInParallel(10);
    }
    
    public String startPush(){
        pushParallelizer.executeInParallel(10);
        return "started!";
    }
}
