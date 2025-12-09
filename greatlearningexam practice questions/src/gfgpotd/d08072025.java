package gfgpotd;
import java.util.*;
public class d08072025 {
    public static void main(String[] args) {
        int[] arr = {2,1,1,3,2,1};
        System.out.println(findGreater(arr));
    }

    public static ArrayList<Integer> findGreater(int[] arr) {
        // code here

        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        Stack<int[]> stack = new Stack();

        //stack.push(new int[]{arr[arr.length-1],map.get(arr.length-1)});

        //list.add(0,-1);

        int i = arr.length-1;

        while(i>0)
        {
            while(!stack.empty() && stack.peek()[1] < map.get(arr[i]))
            {
                //System.out.println(stack.peek()[1]);
                stack.pop();
            }

            list.add(0, stack.empty()?-1:stack.peek()[0]);

            stack.push(new int[]{arr[i],map.get(arr[i])});

            // System.out.println("i is "+ i);
            // printStack(stack);
            i--;
        }
        return list;

    }
    public static void printStack(Stack<int[]> stack)
    {
        while(!stack.empty())
        {
            System.out.println(stack.peek()[0] +" "+ stack.peek()[1]);
            stack.pop();
        }
    }
}
