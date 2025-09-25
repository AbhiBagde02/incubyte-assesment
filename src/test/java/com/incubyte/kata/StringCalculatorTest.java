package com.incubyte.kata;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void returnZeroForrEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }

    @Test
    void returnNumberForSingleNumber(){
        assertEquals(1,StringCalculator.add("1"));
    }

    @Test
    void returnSumOfTwoNumbers(){
        assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    void returnSumOfMultipleNumbers(){
        assertEquals(6,StringCalculator.add("1,2,3"));
    }

    @Test
    void supportNewLineSeparators(){
        assertEquals(6,StringCalculator.add("1\n2,3"));
    }
    @Test
    void supportCustomDelimiter(){
        assertEquals(3,StringCalculator.add("//;\n1;2"));
    }
}
