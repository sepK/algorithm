package tk;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author t.k
 * @date 2021/4/11 14:33
 */
public class TwoSum_1 {


    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{};
        }
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!result.containsKey(target - nums[i])) {
                result.put(nums[i], i);
                continue;
            }
            return new int[]{result.get(target - nums[i]), i};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] sum = twoSum(nums, 6);
        System.out.println(sum[0] + "," + sum[1]);
    }
}
