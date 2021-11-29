package tk.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * @author t.k
 * @date 2021/11/23 13:53
 */
public class SlidingWindow {
    void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.merge(t.charAt(i), 1, Integer::sum);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移⼊窗⼝的字符
            char c = s.charAt(right);
            // 右移窗⼝
            right++;
            // 进⾏窗⼝内数据的⼀系列更新

            //...
            /*** debug 输出的位置 ***/
            System.out.println("window: [%d, %d)\n" + left + right);
            /********************/

            // 判断左侧窗⼝是否要收缩 window needs shrink
            while (left < s.length()) {
                // d 是将移出窗⼝的字符
                char d = s.charAt(left);
                // 左移窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
                //...
            }
        }
    }
}
