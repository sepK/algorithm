package tk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t.k
 * @date 2021/4/29 9:41
 */
public class CanCross_403 {
    public static boolean canCross(int[] stones) {
        Map<String, Boolean> isDfs = new HashMap<>();
        return dfs(stones, 1, 0, 1, isDfs);
    }

    private static boolean dfs(int[] stones, int currentIndex, int stayIndex, int k, Map<String, Boolean> isDfs) {
        if (k <= 0) {
            return false;
        }
//        System.out.println("currentIndex:" + currentIndex + ", stayIndex:" + stayIndex + ", k:" + k);
        if (isDfs.containsKey(currentIndex + "_" + stayIndex + "_" + k)) {
            return isDfs.get(currentIndex + "_" + stayIndex + "_" + k);
        }
        isDfs.put(currentIndex + "_" + stayIndex + "_" + k, true);
        if (currentIndex == stones.length - 1) {
            return true;
        }
        if (stones[currentIndex] - stones[stayIndex] == k) {
            //下一个位置的index
            return dfs(stones, currentIndex + 1, currentIndex, k - 1, isDfs) || dfs(stones, currentIndex + 1, currentIndex, k, isDfs) || dfs(stones, currentIndex + 1, currentIndex, k + 1, isDfs) || dfs(stones, currentIndex + 1, stayIndex, k, isDfs);
        } else if (stones[currentIndex] - stones[stayIndex] < k) {
            return dfs(stones, currentIndex + 1, stayIndex, k, isDfs);
        }

        return false;
    }


    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones));
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 1, 3, 6, 10, 13, 14}));
        System.out.println(canCross(new int[]{0,1,3,6,7}));
    }

}
