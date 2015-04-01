package com.abien.patterns.business.parallelizer.push.control;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class MultiplicationParameters {
    private long a;
    private long b;
    private AtomicBoolean processed;

    public MultiplicationParameters(long a, long b) {
        this.a = a;
        this.b = b;
        this.processed = new AtomicBoolean(false);
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public boolean getAndSetProcessed() {
        return processed.getAndSet(true);
    }

    @Override
    public String toString() {
        return "MultiplicationParameters{" + "a=" + a + ", b=" + b + ", processed=" + processed + '}';
    }
    
}
