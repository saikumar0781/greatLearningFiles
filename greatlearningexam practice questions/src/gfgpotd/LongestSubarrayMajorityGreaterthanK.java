package gfgpotd;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayMajorityGreaterthanK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1};
        int k = 2;
        int res = longestSubarray(arr,k);
        System.out.println("res is " + res);
    }
    public static int longestSubarray(int[] arr, int k) {
        // Code Here

        int left = 0, right = 0,maxlen = 0,count1 = 0, count2 = 0;

        while(right < arr.length)
        {
            if(arr[right] > k)
            {
                count1++;
            }
            else
            {
                count2++;
            }
            if(count1 - count2 >= 1)
            {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            else
            {
                while(left <= right && count1 - count2 < 1)
                {
                    if(arr[left] <= k)
                    {
                        count2--;
                    }
                    else
                    {
                        count1--;
                    }
                    left++;
                }
            }
            right++;
        }
        return maxlen;
    }
}
