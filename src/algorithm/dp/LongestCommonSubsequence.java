package algorithm.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(longestCommonSubsequence(s1, s2));
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];


        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[length1][length2];
    }
}