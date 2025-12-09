package gfgpotd.d29062025;

public class SplitArrayLargestSum1 {
    public static void main(String[] args) {
        //int arr[] = {5,9,3,6,10,3,11,4,5,10,17,11,16,10,7,19,14,11,19,16,11,19,19,4};
        int[] arr = {1,2,3,4,3};
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

        int val = findMaxSum(prefix,k,prefix[n-1]);
        System.out.println("val is "+val);
        //return val;
        System.out.println(binarySearch(prefix,val,val*2,k));
    }
    public static int findMaxSum(int[] prefix,int k,int val)
    {
        int cuts = 0,prevIndex = -1;
        int i = 0, sum = 0;

        while(val > 1) {
            i = 0;
            sum = 0;
            cuts = 0;
            prevIndex = -1;
            while (i < prefix.length && cuts <= k) {
                sum += prefix[i] - (prevIndex == -1 ? 0 : prefix[prevIndex]);
                if (sum > val) {
                    //System.out.println("sum is "+sum +" val is "+val);
                    prevIndex = i - 1;
                    if(i==prefix.length-1 && cuts==k-1){
                        return sum;
                    }
                    else if(i !=prefix.length) {
                        cuts++;
                    }
                    //else cuts++;
                } else if (sum == val) {
                    if(i != prefix.length-1) {
                        cuts++;
                        prevIndex = i;
                    }
                    i++;
                } else
                    i++;
            }
            //System.out.println("val is "+val + " cuts is "+ cuts);
            //if(k==2 && prevIndex != prefix.length-1 && cuts == 1) return val;
            //if(cuts >= k - 1) return val;
            val = (int)Math.ceil((double)val/2);
        }
        return val;
    }
    public static int binarySearch(int[] prefix,int low, int high,int k)
    {
        int mid = 0;
        int ans = -1;
        while(low<=high)
        {
            mid = (low+high)/2;
            int val = findMaxSum(prefix,k,mid);
            System.out.println("mid is "+mid +" val is "+val);

            if(val < mid)
            {
                high = mid -1;
            }
            else if(val == mid)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return findMaxSum(prefix,k,low) == low?low:ans==-1?low:ans;
        //return low;
    }
}
