package leetcode231225_2054;

import java.util.Arrays;

public class MaxTwoEvents {
    public static void main(String[] args) {
        int[][] events = {{10,83,53},{63,87,45},{97,100,32},{51,61,16}};
        int ans = new MaxTwoEvents().maxTwoEvents(events);
        System.out.println(ans);
    }
    public int maxTwoEvents(int[][] events) {

        Arrays.sort(events,(a,b) -> a[0] - b[0]);
        return maxValue(events,-1,0,0);
    }
    public int maxValue(int[][] events,int prev,int curr,int count)
    {
        if(curr == events.length || count == 2) return 0;

        int pick = 0;
        if(prev == -1)
        {
            pick = events[curr][2] + maxValue(events,curr,curr+1,count++);
        }
        else if(prev >=0  && events[prev][1] < events[curr][0])
        {
            pick = events[curr][2] + maxValue(events,curr,curr+1,count++);
        }
        int not_pick = maxValue(events,prev,curr+1,count);

        return Math.max(pick,not_pick);
    }
}
