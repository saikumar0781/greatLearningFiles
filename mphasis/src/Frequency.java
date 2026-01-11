import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency {
    public static void main(String[] args) {

        String s = "hello world";
        s = s.replaceAll(" ","");

        Map<Character, Long> freqMap = s.chars().mapToObj(c -> (char)c).
                collect(Collectors.groupingBy(Function.identity()
                        ,LinkedHashMap::new
                ,Collectors.counting()));
        System.out.println(freqMap);
    }
}
