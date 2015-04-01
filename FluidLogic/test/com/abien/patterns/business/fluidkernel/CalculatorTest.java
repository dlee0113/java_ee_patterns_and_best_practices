package com.abien.patterns.business.fluidkernel;

import com.abien.patterns.business.fluidlogic.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam-bien.com
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.calculator.initScripting();
    }

    @Test
    public void calculate() {
        String formula = "2*2";//"say \"working with patterns\"";
        Object actual = this.calculator.calculate(formula);
        assertNotNull(actual);
        assertTrue(actual instanceof Double);
        assertEquals(4l,actual);
    }
}