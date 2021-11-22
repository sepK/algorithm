package tk.problem;

import java.util.*;

/**
 * @author t.k
 * @date 2020/7/15 17:22
 */
public class CountSmaller {

    private int[] sum;
    private int[] temp;


    public int lowBit(int x) {
        return x & -x;
    }

    public void update(int i, int val) {

        while (i < temp.length) {
            temp[i] += val;
            i += lowBit(i);
        }
    }

    public long sum(int i) {
        long result = 0;
        while (i > 0) {
            result += temp[i];
            result -= lowBit(i);
        }
        return result;
    }

    public List<Integer> countSmaller(int[] nums) {
        //去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Object[] temp = set.toArray();
        int index = 0;
        for (Integer integer : set) {
            temp[index++] = integer;
        }
        //排序
        Arrays.sort(temp);



        return new ArrayList<>();
    }

}
