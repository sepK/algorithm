package tk.problem;

/**
 * @author t.k
 * @date 2021/4/30 14:01
 */
public class MaxSubArray_53 {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2}));
    }
}
