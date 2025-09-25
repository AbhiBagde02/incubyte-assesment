package com.incubyte.kata;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void returnZeroForrEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }


}
