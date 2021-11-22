package tk.problem;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 *
 * @author t.k
 * @date 2021/4/12 10:23
 */
public class FindMedianSortedArrays_4 {

    /**
     * 时间复杂度是大O(N + M)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并两个数组
        int[] finalArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j >= nums2.length) {
                finalArray[k++] = nums1[i];
                i++;
                continue;
            }
            if (i >= nums1.length) {
                finalArray[k++] = nums1[j];
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                finalArray[k++] = nums1[i];
                i++;
            } else {
                finalArray[k++] = nums2[j];
                j++;
            }
        }
        int size = finalArray.length % 2;
        int median = finalArray.length / 2;
        if (size == 0) {
            return (finalArray[median] + finalArray[median + 1]) / 2.0d;
        }

        return finalArray[median];
    }

    public static int findKth(int[] nums1, int nums1L, int nums1R, int[] nums2, int nums2L, int nums2R, int index) {
        int len1 = nums1R - nums1L + 1;
        int len2 = nums2R - nums2L + 1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) {
            return findKth(nums2, nums2L, nums2R, nums1, nums1L, nums1R, index);
        }
        if (len1 == 0) {
            return nums2[nums2L + index - 1];
        }

        if (index == 1) {
            return Math.min(nums1[nums1L], nums2[nums2L]);
        }

        int i = nums1L + Math.min(len1, index / 2) - 1;
        int j = nums2L + Math.min(len2, index / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findKth(nums1, nums1L, nums1R, nums2, j + 1, nums2R, index - (j - nums2L + 1));
        } else {
            return findKth(nums1, i + 1, nums1R, nums2, nums2L, nums2R, index - (i - nums1L + 1));
        }
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        return (findKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + findKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) / 2.0d;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[]{4, 5, 6, 7};
        double medianSortedArrays = findMedianSortedArrays2(a, b);
        System.out.println(medianSortedArrays);
    }
}
