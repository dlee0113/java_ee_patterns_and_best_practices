package com.abien.patterns.business.order.domain;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam-bien.com
 */
public class LoadTest {

    @Test
    public void builderCreatesDistinctInstances() {
        Load first = new Load.Builder().withBulkyItem(1).build();
        Load second = new Load.Builder().withBulkyItem(2).build();
        assertThat(first.getNumberOfOrderItems(), is(1));
        assertThat(second.getNumberOfOrderItems(), is(1));
        assertNotSame(first, second);
    }

}
