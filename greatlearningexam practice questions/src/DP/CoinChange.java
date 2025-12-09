package DP;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2};
        int amount = 5;
        int count = 0;
        int ans = coinsCount(coins,amount,0,count);
        int i = count == 0 ? -1 : ans;
        System.out.println(i);
    }
    public static int coinsCount(int[] coins, int amount, int i,int count) {
        if (i == coins.length || amount == 0) return 0;
        if (amount >= coins[i]) {
            coinsCount(coins, amount - coins[i], i, count + 1);
            coinsCount(coins, amount, i + 1, count);
    } else
        {
             coinsCount(coins,amount,i+1,count);
        }
        return 0;
    }
}