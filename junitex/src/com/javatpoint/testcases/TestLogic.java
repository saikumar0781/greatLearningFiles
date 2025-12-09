package com.javatpoint.testcases;

import com.javatpoint.logic.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLogic {

    @Test
    public void findTestMax()
    {
        assertEquals(4, Calculator.findMax(new int[]{1,2,3,4}));
        assertEquals(-1,Calculator.findMax(new int[]{-1,-5,-3,-2}));
    }
}
