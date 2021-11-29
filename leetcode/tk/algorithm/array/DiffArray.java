package tk.algorithm.array;

/**
 * 差分数组
 *
 * @author t.k
 * @date 2021/11/23 11:01
 */
public class DiffArray {
    /**
     * 构造差分数组
     *
     * @param nums
     * @return
     */
    public int[] build(int[] nums) {
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        return diff;
    }

    /**
     * 根据差分数组构造结果数组
     *
     * @param diff
     */
    public void reverse(int[] diff) {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
    }

    public void increment(int i, int j, int val, int[] diff) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
}
