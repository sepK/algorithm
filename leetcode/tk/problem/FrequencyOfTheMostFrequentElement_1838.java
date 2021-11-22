package tk.problem;

import java.util.Arrays;

/**
 * @author t.k
 * @date 2021/7/19 16:21
 */
public class FrequencyOfTheMostFrequentElement_1838 {

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int left = 0;
        int right = length - 1;

        while (true) {
            int need = (right - left) * nums[right] - sum[right] + sum[left];
            if (need <= k) {
                break;
            }
            int rightSum = (right - left - 1) * nums[right] - sum[right] + sum[left + 1];
            int leftSum = (right - left - 1) * nums[right - 1] - sum[right - 1] + sum[left];
            if (leftSum >= rightSum) {
                left++;
            } else {
                right--;
            }

        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
        System.out.println(maxFrequency(nums, 3056));
    }
}
