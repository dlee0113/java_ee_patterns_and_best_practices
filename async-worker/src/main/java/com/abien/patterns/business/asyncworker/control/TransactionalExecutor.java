package com.abien.patterns.business.asyncworker.control;

import java.util.concurrent.Executor;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class TransactionalExecutor implements Executor{

    @Override @Asynchronous
    public void execute(Runnable command) {
        command.run();
    }
}
