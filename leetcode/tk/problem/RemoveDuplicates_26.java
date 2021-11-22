package tk.problem;

import tk.algorithm.utils.Utils;

/**
 * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
 *
 * @author t.k
 * @date 2021/4/19 10:00
 */
public class RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int first = 0;
        int second = 0;
        while (second < nums.length) {
            if (nums[second] == nums[first]) {
                second++;
            } else {
                first++;
                nums[first] = nums[second];
                second++;
            }
        }
        return first + 1;
    }

    public static void main(String[] args) {
//        int[] generateRandomArray = ArrayLogarithmGeneratorUtils.generateRandomArray(10, 100);
//        QuickSort.quickSort(generateRandomArray, 0, generateRandomArray.length - 1);
        int[] generateRandomArray = new int[]{1};
        Utils.printArray(generateRandomArray);
        System.out.println(removeDuplicates(generateRandomArray));
        Utils.printArray(generateRandomArray);
    }
}
