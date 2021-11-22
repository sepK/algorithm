package tk.problem;

/**
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * @author t.k
 * @date 2021/4/19 16:09
 */
public class Search_33 {

    public static int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length - 1, target);
    }

    private static int bSearch(int[] nums, int l, int r, int target) {
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        if (l == r) {
            return -1;
        }
        int start = nums[l];
        int mid = (l + r) / 2;
        int end = nums[r];
        if (target >= start) {
            if (start <= nums[mid]) {
                if (target <= nums[mid]) {
                    return bSearch(nums, 0, mid, target);
                } else {
                    return bSearch(nums, mid + 1, r, target);
                }
            } else {
                return bSearch(nums, 0, mid, target);
            }
        } else if (target <= end) {
            if (nums[mid] < end && target <= nums[mid]) {
                return bSearch(nums, 0, mid, target);
            } else {
                return bSearch(nums, mid + 1, r, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //todo if太多了 可以优化下
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2,3};
        System.out.println(search(nums, 4));
        System.out.println(search(nums, 5));
        System.out.println(search(nums, 6));
        System.out.println(search(nums, 7));
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 1));
        System.out.println(search(nums, 2));
        System.out.println(search(nums, 3));
    }
}
