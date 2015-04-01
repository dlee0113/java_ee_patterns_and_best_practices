package com.abien.business.patterns.threadtracker;

import java.lang.reflect.Method;
import javax.interceptor.InvocationContext;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Adam Bien, adam-bien.com
 */
public class ThreadTrackerTest {

    private ThreadTracker cut;
    private String threadName;

    @Before
    public void initialize() {
        this.cut = new ThreadTracker();
    }

    @Test
    public void annotateThread() throws Exception {
        InvocationContext ic = mock(InvocationContext.class);
        Method method = ThreadTrackerTest.class.getMethod("annotateThread", (Class[])null);
        
        when(ic.getMethod()).thenReturn(method);
        when(ic.getTarget()).thenReturn(this);
        when(ic.proceed()).thenAnswer(new Answer<Object>() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ThreadTrackerTest.this.setThreadName(Thread.currentThread().getName());
                return null;
            }
        });

        this.cut.annotateThread(ic);

        assertTrue(threadName.startsWith(this.getClass().getName()));
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
