package tk.problem;

/**
 * @author t.k
 * @date 2020/6/1 15:48
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int start = nums.length - 1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = start < i ? start : i;
                end = end > i ? end : i;
            }
        }
        if (end == -1) {
            start = -1;
        }
        return new  int[]{start, end};
    }


    public static void binarySearch(int[] nums, int target, int right, int left){


    }

    public static void main(String[] args) {
        int[] searchRange = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 4);
        System.out.println(searchRange);
    }
}
