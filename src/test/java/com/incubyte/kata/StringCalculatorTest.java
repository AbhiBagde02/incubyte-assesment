package com.incubyte.kata;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void throwExceptinoForNegatives(){
        Exception ex = assertThrows(IllegalArgumentException.class,() -> StringCalculator.add("-1,2,-3"));
        assertEquals("Negative numbers are not allowed: -1,-3", ex.getMessage());
    }

    @Test
    void ignoreNumbersGreaterThan1000(){
        assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    void supportsMultiCharDelimiters(){
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }
    @Test
    void supportsMultipleDelimiters() {
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void supportsMultipleLongDelimiters() {
        assertEquals(6, StringCalculator.add("//[***][%%]\n1***2%%3"));
    }

    @Test
    void supportsAestricDelimiter() {
        assertEquals(6,StringCalculator.add("//*\n2*3"));
    }
}
