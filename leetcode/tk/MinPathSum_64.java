package tk;

/**
 * @author t.k
 * @date 2021/4/26 15:40
 */
public class MinPathSum_64 {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        for (int k = 1; k < n; k++) {
            dp[0][k] += dp[0][k - 1] + grid[0][k];
        }
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                dp[i][k] = grid[i][k] + Math.min(dp[i - 1][k], dp[i][k - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
