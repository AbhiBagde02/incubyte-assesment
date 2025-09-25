package com.incubyte.kata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String  numbers){
       if(numbers.isEmpty()) return 0;
       String delimiter = "[, \n]";
       if(numbers.startsWith("//")){
           int delimiterIndex = numbers.indexOf('\n');
           String delimiterPart = numbers.substring(2, delimiterIndex);
           List<String> delimiters = new ArrayList<>();
           Matcher multiDelimMatcher = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
           while (multiDelimMatcher.find()) {
               delimiters.add(Pattern.quote(multiDelimMatcher.group(1)));
           }
           if (delimiters.isEmpty()) {
               delimiters.add(Pattern.quote(delimiterPart));
           }
           delimiter = String.join("|", delimiters);
           numbers = numbers.substring(delimiterIndex + 1);
       }
       String[] parts = numbers.split(delimiter);
       List<Integer> negatives = Arrays.stream(parts).mapToInt(Integer::parseInt).filter(n -> n < 0).boxed().toList();
       if(!negatives.isEmpty()){
           throw new IllegalArgumentException("Negative numbers are not allowed: " + negatives.stream().map(String::valueOf).collect(Collectors.joining(",")));
       }
       return Arrays.stream(parts).mapToInt(Integer::parseInt).filter(n -> n <= 1000).sum();
    }

}
