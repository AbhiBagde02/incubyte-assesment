package com.incubyte.kata;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
       List<Integer> negatives = Arrays.stream(parts).mapToInt(Integer::parseInt).filter(n -> n < 0).boxed().toList();
       if(!negatives.isEmpty()){
           throw new IllegalArgumentException("Negative numbers are not allowed: " + negatives.stream().map(String::valueOf).collect(Collectors.joining(",")));
       }
       return Arrays.stream(parts).mapToInt(Integer::parseInt).sum();
    }

}
