package tk.problem;

/**
 * 打家劫舍
 *
 * @author t.k
 * @date 2021/7/13 18:57
 */
public class HouseRobber_198 {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            //dp[i + 2] = dp[i] + dp[i + 1];
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
