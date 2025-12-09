package nagarro;

import java.util.*;
public class StringChange {

    public static void main(String[] args) {

        String s = "thisIsAVariable";
        int n = s.length();
        String s1 = "";
        String output = "";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)-'A' >=0 && s.charAt(i)-'A' <=26)
            {
                s1 = s.substring(0,i) + "_"+ Character.toLowerCase(s.charAt(i));
                if(i+1<n)
                {
                    s = s1 + s.substring(i+1);
                }
            }
        }
        System.out.println("output is " + s);
    }


}
