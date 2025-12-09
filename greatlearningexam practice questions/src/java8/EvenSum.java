package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EvenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int sum = Arrays.stream(arr).filter(n->n%2==0).sum();
        System.out.println(sum);
    }
}
