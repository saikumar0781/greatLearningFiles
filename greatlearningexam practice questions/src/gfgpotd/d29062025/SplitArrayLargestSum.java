package gfgpotd.d29062025;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        //int arr[] = {5,9,3,6,10,3,11,4,5,10,17,11,16,10,7,19,14,11,19,16,11,19,19,4};
        //int[] arr = {12,12,12,19,7,6,8,9,19,1};
        //int[] arr = {7,3,8,16,19,1,5,2,2,16,1,19};
        int[] arr = {3 ,5 ,2 ,9 ,18 ,9};
        int k = 3;
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            prefix[i] = prefix[i-1]+arr[i];
        }
        //System.out.println(prefix[n-1]);

        if(k==1) System.out.println(prefix[n-1]);
        int val = prefix[n-1];

        while(val > 1)
        {
            int cuts= findMaxSum(prefix,k,val);
            System.out.println("val is "+val+" cuts is "+ cuts);
            if(cuts < k)
                val = val/2;
            else break;
        }

        //int cuts = findMaxSum(prefix,k,49);
        //System.out.println("val is "+val);
        //return val;
        System.out.println(Math.min(binarySearch(prefix,val,val*2,k),binarySearch(prefix,val/2,val,k)));
    }
    public static int findMaxSum(int[] prefix,int k,int val)
    {
        int cuts = 0,prevIndex = -1;
        int i = 0, sum = 0;

            while (i < prefix.length && cuts <= k) {
                sum = prefix[i] - (prevIndex == -1 ? 0 : prefix[prevIndex]);
                if (sum > val) {
                    //System.out.println("sum is "+sum +" val is "+val);
                    if(i !=prefix.length-1 || (i == prefix.length-1 && prevIndex != i-1)) {
                        cuts++;
                    }
                    prevIndex = i - 1;
                    //else cuts++;
                } else if (sum == val) {
                        cuts++;
                        prevIndex = i;
                        i++;
                } else {
                    if((i==prefix.length-1 && cuts == k-1) || (i==prefix.length-1 && prevIndex != i))
                    {
                        cuts++;
                    }
                    i++;
                }
            }
            //if(prevIndex != prefix.length-1) cuts++;
        return cuts;
    }
    public static int binarySearch(int[] prefix,int low, int high,int k)
    {
        int mid = 0;
        int ans = -1;
        while(low<=high)
        {
            System.out.println("low is "+ low + " high is "+ high);
            mid = (low+high)/2;
            int cuts = findMaxSum(prefix,k,mid);
            System.out.println("mid is "+mid +" val is "+cuts);

            if(cuts<k)
            {
                high = mid  - 1;
            }
            else if(cuts == k)
            {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return findMaxSum(prefix,k,low) == low?low:ans==-1?low:ans;
        //return low;
    }
}
