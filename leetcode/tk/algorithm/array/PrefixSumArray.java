package tk.algorithm.array;

/**
 * 前缀和
 *
 * @author t.k
 * @date 2021/11/23 11:04
 */
public class PrefixSumArray {
    private int[] prefix;

    /**
     * 输⼊⼀个数组，构造前缀和
     *
     * @param nums
     */
    public void prefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    /**
     * 查询闭区间 [i, j] 的累加和
     *
     * @param i
     * @param j
     * @return
     */
    public int query(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

}
