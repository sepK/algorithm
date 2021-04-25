package tk;

import tk.algorithm.utils.ArrayLogarithmGeneratorUtils;
import tk.algorithm.utils.Utils;

/**
 * @author t.k
 * @date 2021/4/20 10:14
 */
public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= nums.length || num < 0 || nums[num] == num) {
                continue;
            }
            nums[i] = nums[num];
            nums[num] = num;
            i--;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        if (nums[0] == nums.length) {
            return nums.length + 1;
        }
        return nums.length;
    }
    public static int firstMissingPositiveCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] temp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= temp.length || num < 0) {
                continue;
            }
            temp[num] = num;
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != i) {
                return i;
            }
        }
        return temp.length;
    }

    public static void main(String[] args) {
        for (int i = 0; i< 50000000;i++) {
            int[] generateRandomArray =  ArrayLogarithmGeneratorUtils.generateRandomArray(10, 20);
            int firstMissingPositiveCurrent = firstMissingPositiveCurrent(generateRandomArray);
            int firstMissingPositive = firstMissingPositive(generateRandomArray);
            if (firstMissingPositive != firstMissingPositiveCurrent) {
                Utils.printArray(generateRandomArray);
                System.out.println("error" + firstMissingPositive + "," + firstMissingPositiveCurrent);
            }
        }
    }
}
