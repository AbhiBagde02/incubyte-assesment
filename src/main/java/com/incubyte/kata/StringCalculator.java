package com.incubyte.kata;

import java.util.Arrays;

public class StringCalculator {

    public static int add(String  numbers){
       if(numbers.isEmpty()) return 0;
       String[] parts = numbers.split("[, \n]");
       return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

}
