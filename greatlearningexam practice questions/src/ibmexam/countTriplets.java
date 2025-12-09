package ibmexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class countTriplets {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(0,3,4,1,2,8); //048 012 018 042 342 348 312 318
        int d = 3;
        System.out.println(countTriplets(a,d));
    }
    public static int countTriplets(List<Integer> a, int d)
    {
        int n = a.size();
        HashMap<Integer,Integer> map =new HashMap<>();
        HashMap<Integer,Integer> newmap =new HashMap<>();

        int count =0 ;

        for(int i =0;i<n;i++)
        {
            int rem = a.get(i)%d;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        newmap.putAll(map);

        for(int i=0;i<n-2;i++)
        {
            map.put(a.get(i)%d,map.get(a.get(i)%d)-1);
            newmap.put(a.get(i)%d,newmap.get(a.get(i)%d)-1);
            for(int j=i+1;j<n-1;j++)
            {
                map.put(a.get(j)%d,map.get(a.get(j)%d)-1);
                int add = (a.get(i)+a.get(j))%d==0? d:(a.get(i)+a.get(j))%d;

                   if(map.containsKey(d-add))
                    {
                        count += map.get(d-add);
                    }
            }
            map.putAll(newmap);
        }
        return count;
    }
}
