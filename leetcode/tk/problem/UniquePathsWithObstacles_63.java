package tk.problem;

/**
 * @author t.k
 * @date 2021/4/26 15:21
 */
public class UniquePathsWithObstacles_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int k = 1; k < n; k++) {
            if (obstacleGrid[0][k] == 1) {
                dp[0][k] = 0;
            } else {
                dp[0][k] = dp[0][k - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                if (obstacleGrid[i][k] == 1) {
                    dp[i][k] = 0;
                } else {
                    dp[i][k] = dp[i - 1][k] + dp[i][k - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //todo 可以通过滚动数组 来优化空间复杂度
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}
