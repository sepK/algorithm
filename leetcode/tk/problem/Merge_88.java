package tk.problem;

import tk.algorithm.utils.Utils;

/**
 * @author t.k
 * @date 2021/4/20 14:07
 */
public class Merge_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, k = n - 1;
        while (i >= 0 || k >= 0) {
            if (i < 0) {
                nums1[i + k + 1] = nums2[k];
                k--;
            } else if (k < 0) {
                nums1[i + k + 1] = nums1[i];
                i--;
            } else if (nums1[i] >= nums2[k]) {
                nums1[i + k + 1] = nums1[i];
                i--;
            } else {
                nums1[i + k + 1] = nums2[k];
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        Utils.printArray(nums1);
    }
}
