package gfg091225;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> ans = findDuplicates(new int[]{2,3,1,2,3});
        Collections.sort(ans);
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(2);
        actual.add(3);
        System.out.println(ans.equals(actual));

    }
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> output = new ArrayList<Integer>();

        for(int i = 0;i<arr.length;i++)
        {
            int idx = Math.abs(arr[i]) -1;

            if(arr[idx] < 0)
            {
                output.add(Math.abs(arr[i]));
            }
            else
            {
                arr[idx] = -arr[idx];
            }
        }
        return output;
    }
}
