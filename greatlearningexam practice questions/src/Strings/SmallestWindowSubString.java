package Strings;

import java.util.*;
public class SmallestWindowSubString {
    public static void main(String[] args) {
        smallestWindow("timetopractice","toc");
    }
    public static String smallestWindow(String s, String p) {
        // code here

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        for(int i = 0;i<p.length();i++)
        {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }

        //System.out.println(map);

        String output = "";
        int max = Integer.MAX_VALUE;

        int i = 0,j=0;

        while(j < s.length())
        {
            if(map.containsKey(s.charAt(j)))
            {
                map1.put(s.charAt(j), map1.getOrDefault(s.charAt(j),0)+1);
            }
            //System.out.println(map1);
            while(i <= j && isMatch(map1,map))
            {
                if(isMatch(map1,map) && j - i + 1 < max)
                {
                    output = s.substring(i,j + 1);
                    max = j - i + 1;
                }
                //System.out.println(j + " j " + i + " i + map 1 is "+map1);
                Integer count = map1.get(s.charAt(i));
                if(count != null)
                {
                    if(count > map.get(s.charAt(i)))
                    {
                        map1.put(s.charAt(i),map.get(s.charAt(i))-1);
                    }
                    else
                    {
                        map1.remove(s.charAt(i));
                    }
                }
                i++;

                //System.out.println("map size " + map1 + " " + output);
            }
            j++;
        }
        // while(i <= s.length() && isMatch(map1,map))
        //     {
        //         if(j - i + 1 < max)
        //         {
        //             output = s.substring(i,j + 1);
        //             max = j - i + 1;
        //         }
        //     }
        return output;

    }
    public static boolean isMatch(Map<Character,Integer> map2, Map<Character,Integer> map3)
    {
        for(Character key : map3.keySet())
        {
            if(!map2.containsKey(key))
            {
                return false;
            }
            else if(map2.get(key) < map3.get(key))
            {
                return false;
            }
        }
        return true;
    }
}