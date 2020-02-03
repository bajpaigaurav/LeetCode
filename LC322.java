import java.util.Arrays;

class Solution322 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0; i < dp.length ; i++) {
            dp[i] = amount+1; // or any max value
        }
        dp[0] = 0; // stop case - no amount means no coins needed :)
        for(int j = 1; j <= amount; ++j) {
            for(int i = 0 ; i < coins.length; ++i ){
                if(coins[i] <= j) {

                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount]; // for flagging -1 in case of no result
    }
}