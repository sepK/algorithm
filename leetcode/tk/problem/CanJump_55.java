package tk.problem;

/**
 * @author t.k
 * @date 2021/4/29 16:56
 */
public class CanJump_55 {

    public static boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxIndex < i) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
