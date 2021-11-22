package tk.problem;

/**
 * @author t.k
 * @date 2020/7/10 14:33
 */
public class NumArray {
    private int[] sum;
    private int[] numArrays;

    public NumArray(int[] nums) {
        this.numArrays = nums;
        sum = new int[nums.length + nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void add(int i, int val) {
        while (i <= numArrays.length) {
            sum[i] += val;
            i += lowBit(i);
        }
    }

    public void update(int i, int val) {
        add(i + 1, val - numArrays[i]);
        numArrays[i] = val;
    }

    public int sum(int i) {
        int result = 0;
        while (i > 0) {
           result += sum[i];
           i -= lowBit(i);
        }
        return result;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }



    public int lowBit(int x) {
        return x & (-x);
    }


    /**
     * ["tk.problem.NumArray","sumRange","update","update","update","update","sumRange"]
     [[[5,18,13]],[0,2],[1,-1],[2,3],[0,5],[0,-4],[0,2]]
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5,18,13};
        NumArray obj = new NumArray(nums);
        obj.update(0, 2);
        obj.update(1, -1);
        obj.update(2, 3);
        obj.update(0, 5);
        obj.update(0, -4);
        System.out.println( obj.sumRange(0,2));
    }
}
