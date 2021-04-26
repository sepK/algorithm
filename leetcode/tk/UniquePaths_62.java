package tk;

/**
 * 不同路径
 * @author t.k
 * @date 2021/4/26 14:51
 */
public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int k = 0; k < n; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                dp[i][k] = dp[i - 1][k] + dp[i][k - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }
}
