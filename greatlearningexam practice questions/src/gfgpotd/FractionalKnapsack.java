package gfgpotd;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = new Item[]{new Item(60,10),new Item(100,20),new Item(120,30)};
        System.out.println(fractionalKnapsack(50,arr,3));

    }
    public static double fractionalKnapsack(int W,Item[] arr,int N)
    {
        return fractionalKnapsackMem(W,arr,N);
    }
    public static double fractionalKnapsackMem(int W,Item[] arr, int n)
    {
        if(n==1) return 0;
        if(arr[n-1].weight>W) return (W/arr[n-1].weight)*arr[n-1].value;

        if(W>=arr[n-1].weight)
        {
            return Math.max(arr[n-1].value+fractionalKnapsackMem(W-arr[n-1].weight,arr,n),
                    arr[n-1].value+fractionalKnapsackMem(W-arr[n-1].weight,arr,n-1));
        }
        return fractionalKnapsackMem(W,arr,n-1);
    }
}
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
