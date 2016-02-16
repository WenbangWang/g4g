package algorithm.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int n = 4;

        System.out.println(coinChange(coins, n));
    }

    public static int coinChange(int[] coins, int n) {
        int length = coins.length;
        int[][] dp = new int[n + 1][length + 1];

        Arrays.fill(dp[0], 1);

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= length; j++) {
                dp[i][j] = dp[i][j - 1] + ((i - coins[j - 1]) >= 0 ? dp[i - coins[j - 1]][j] : 0);
            }
        }

        return dp[n][length];
    }
}