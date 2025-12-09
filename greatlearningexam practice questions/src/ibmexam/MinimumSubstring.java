package ibmexam;
import java.util.*;
public class MinimumSubstring {
    public static void main(String[] args) {
        String s = "01212";
        System.out.println(smallestSubstring(s));
    }
    public static int smallestSubstring(String S) {
        // Code here

        Map<Character,Integer> map = new HashMap<>();

        int smallest = Integer.MAX_VALUE;

        int n = S.length();
        int i=0,j=0;
        while(i<=j)
        {

            if(map.containsKey('0') && map.containsKey('1') && map.containsKey('2'))
            {
                smallest = Math.min(smallest,Math.min(n-1,j)-i+1);
                Character c = S.charAt(i);
                if(map.get(c)==1)
                {
                    map.remove(c);
                }
                else
                {
                    map.put(c,map.get(c)-1);
                }
                i++;
            }
            else if(j==n && !(map.containsKey('0') && map.containsKey('1')&&map.containsKey('2')))
            {
                break;
            }

            if(j!=n)
            {
                Character c = S.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
                j++;
            }
        }
        return smallest;
    }
}
