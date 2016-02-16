package algorithm.dp;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}
        };

        System.out.println(minCostPath(matrix));
    }

    public static int minCostPath(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i - 1][0];
        }

        for (int i = 1; i <= y; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i - 1];
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + matrix[i - 1][j - 1];
            }
        }

        return dp[x][y];
    }
}