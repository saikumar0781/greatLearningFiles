package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurences {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"apple","banana","mango","apple","orange","apple"});
        String output = "apple";

        long count = list.stream().filter(word-> word.equals("apple")).count();
        Map<String,Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map.get(output));
//        String input = "gainjavaknowledge";
//
//        Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println("Output : "+output);
    }
}
