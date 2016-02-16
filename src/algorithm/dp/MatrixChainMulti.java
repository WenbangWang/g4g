package algorithm.dp;

import java.util.Arrays;

public class MatrixChainMulti {

    public static void main(String[] args) {
        int[] array = {40,20,30,10,30};

        System.out.println(matrixChainMulti(array));
    }

    public static int matrixChainMulti(int[] array) {
        int length = array.length;
        int[][] dp = new int[length][length];

        for(int chainLength = 2; chainLength < length; chainLength++) {
            for(int start = 1; start <= length - chainLength; start++) {
                int end = start + chainLength - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for(int pointer = start; pointer < end; pointer++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][pointer] + dp[pointer + 1][end] + array[start - 1] * array[pointer] * array[end]);
                }
            }
        }

        return dp[1][length - 1];
    }
}