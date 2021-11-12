package tk;

/**
 * @author t.k
 * @date 2021/8/23 9:00
 */
public class GetMaximumInGeneratedArray_1646 {

    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 0; i <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int maximumGenerated = getMaximumGenerated(100);
        System.out.println("result: " + maximumGenerated);
    }
}
