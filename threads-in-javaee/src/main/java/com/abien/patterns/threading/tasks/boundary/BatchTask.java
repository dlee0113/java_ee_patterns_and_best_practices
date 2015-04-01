package com.abien.patterns.threading.tasks.boundary;

import com.abien.patterns.threading.tasks.control.LongTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class BatchTask {
    @Inject
    LongTask lt;

    public void executeBatch() {
        List<Future<String>> results = new ArrayList();
        //fan out
        long start = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            results.add(lt.execute());
        }
        System.out.println("##Fan out# " + (System.currentTimeMillis()-start) + " ms");
        //gather results
        start = System.currentTimeMillis();
        for (Future<String> resultProxy : results) {
            try {
                System.out.println("-- "+ resultProxy.get());
            } catch (Exception ex) {  }
        }
        System.out.println("##Gathering# " + (System.currentTimeMillis()-start) + " ms");
    }
}
