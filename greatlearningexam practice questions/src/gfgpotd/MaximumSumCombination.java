package gfgpotd;
import java.util.*;
public class MaximumSumCombination {
    public static void main(String[] args) {
        int[] a = {10,9,5,3,7};
        int[] b = {6,6,3,2,2};
        int k = 5;

        System.out.println(topKSumPairs(a,b,k));
    }
    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int i = a.length -1;
        int j = b.length - 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((c,d) -> d - c);
        pq.add(a[i] + b[j]);
        list.add(pq.poll());

        while(list.size() < k)
        {
            pq.add(a[i-1]+b[j]);
            pq.add(a[i] + b[j-1]);

            while(!pq.isEmpty() && list.size() < k)
            {
                list.add(pq.poll());
            }

            i--;
            j--;
        }
        return list;
    }
}