package java8;

import java.util.List;
import java.util.*;

public class CommonElements {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,5,8,9,10);
        List<Integer> list2 = Arrays.asList(4,3,7,6,9,10);

        list.stream().filter(x->list2.contains(x)).forEach(System.out::println);
    }
}
