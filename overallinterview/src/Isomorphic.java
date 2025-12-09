import java.util.*;
public class Isomorphic {
    public static void main(String[] args) {
        String str1 = "xudzhi";
        String str2 = "ftakcz";
        boolean ans = areIsomorphic(str1,str2);
        System.out.println(ans);
    }
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here

        int n = str1.length();
        int n2 = str2.length();
        if(n!=n2) return false;

        Map<Character,Character> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            if(map.containsKey(str1.charAt(i)))
            {
                if(map.get(str1.charAt(i)) != str2.charAt(i)) return false;
            }
            else if(map.containsKey(str2.charAt(i)))
            {
                if(map.get(str2.charAt(i)) != str1.charAt(i)) return false;
            }
            else
            {
                map.put(str1.charAt(i),str2.charAt(i));
                map.put(str2.charAt(i),str1.charAt(i));

            }
        }
        if(map.containsKey(str1.charAt(n-1)))
        {
            if(map.get(str1.charAt(n-1)) != str2.charAt(n-1)) return false;
        }
        else if(map.containsKey(str2.charAt(n-1)))
        {
            if(map.get(str2.charAt(n-1)) != str1.charAt(n-1)) return false;
        }
        return true;

    }
}
