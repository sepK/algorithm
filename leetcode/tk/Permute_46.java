package tk;

import tk.algorithm.utils.Utils;

import java.util.*;

/**
 * @author t.k
 * @date 2021/4/28 16:44
 */
public class Permute_46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dps(nums, 0, ans);
        return null;
    }

    private static void dps(int[] nums, int currentIndex, List<List<Integer>> ans) {
        if (currentIndex == nums.length) {
            Utils.printArray(nums);
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            Utils.swap(nums, currentIndex, i);
            dps(nums, currentIndex + 1, ans);
            Utils.swap(nums, currentIndex, i);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }
}
