package tk.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author t.k
 * @date 2021/4/11 14:52
 */
public class LengthOfLongestSubstring_3 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int beginIndex = 0;
        Map<Character, Integer> str = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (str.containsKey(word)) {
                beginIndex = Math.max(str.get(word) + 1, beginIndex);
            }
            maxLength = Math.max(i - beginIndex + 1, maxLength);
            str.put(word, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eabcdfce";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
