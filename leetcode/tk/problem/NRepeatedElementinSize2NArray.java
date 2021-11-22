package tk.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t.k 961
 * @date 2019/4/8 14:56
 */
public class NRepeatedElementinSize2NArray {
    public static int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                return i;
            }
            map.put(i, 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        repeatedNTimes(new int[]{1,2,3,3});
    }
}
