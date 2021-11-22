package tk.problem;

import java.util.*;

/**
 * @author t.k
 * @date 2021/4/14 14:39
 */
public class ThreeSum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(-nums[i])) {
                continue;
            }
            result.put(nums[i], i);
            twoSum(nums, -nums[i], i, resultList);
        }
        return resultList;
    }

    public static List<Integer> twoSum(int[] nums, int target, int currentIndex, List<List<Integer>> resultList) {
        if (nums == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!result.containsKey(target - nums[i])) {
                result.merge(nums[i], 1, Integer::sum);
                continue;
            }
            result.merge(nums[i], 1, Integer::sum);
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(target - nums[i]);
            list.add(nums[currentIndex]);
            resultList.add(list);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] h = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(h));
        h = new int[]{};
        System.out.println(threeSum(h));
        h = new int[]{0};
        System.out.println(threeSum(h));
        h = new int[]{4, 3, 2, 1, 4};
        System.out.println(threeSum(h));
    }
}
