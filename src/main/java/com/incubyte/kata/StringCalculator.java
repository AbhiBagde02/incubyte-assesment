package com.incubyte.kata;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String  numbers){
       if(numbers.isEmpty()) return 0;
       String delimiter = "[, \n]";
       if(numbers.startsWith("//")){
           int delimiterIndex = numbers.indexOf('\n');
           delimiter = Pattern.quote(numbers.substring(2,delimiterIndex));
           numbers = numbers.substring(delimiterIndex + 1);
       }
       String[] parts = numbers.split(delimiter);
       return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

}
