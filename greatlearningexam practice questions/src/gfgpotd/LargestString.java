package gfgpotd;
import java.util.*;
public class LargestString {
    public static void main(String[] args) {
        int n = 6;
        String arr[] = {"9",
                "99",
                "992",
                "991",
                "900",
                "69"};
        System.out.println(printLargest(n,arr));
    }
    static String printLargest(int n, String[] arr) {
        // code here

        PriorityQueue<String> pq = new PriorityQueue<String>(new StringComparator());

        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);
        }
        //System.out.println(pq);
        String ans = "";
        while(!pq.isEmpty())
        {
            ans += pq.poll();
        }
        return ans;
    }
}
class StringComparator implements Comparator<String>
{
    public int compare(String a, String b)
    {
        if(a.length()==b.length()){
            if(Integer.parseInt(a)==Integer.parseInt(b))
            {
                return 0;
            }
            else
            {
                return Integer.parseInt(b)-Integer.parseInt(a);
            }
        }
        else
        {
            int len = a.length()<b.length() ? a.length():b.length();
            if(a.length()<b.length())
            {
                if(b.charAt(len)- a.charAt(len-1)>0)
                    return 1;
            }

            else
            {
                return a.charAt(len)-b.charAt(len-1);
            }
            return 0;
        }
    }
}