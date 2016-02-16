package algorithm.dp;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        System.out.println(editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 == 0 || length2 == 0) {
            return Math.abs(length1 - length2);
        }

        int[][] dp = new int[length1 + 1][length2 + 1];

        for(int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for(int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[length1][length2];
    }
}