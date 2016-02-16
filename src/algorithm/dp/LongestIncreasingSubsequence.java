package algorithm.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };

        System.out.println(longestIncreasingSubsequence(array));
    }

    public static int longestIncreasingSubsequence(int[] array) {
        int length = array.length;
        int[] dp = new int[length];

        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < length; i++) {
            for(int j = 0; j < i; j++) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }
}