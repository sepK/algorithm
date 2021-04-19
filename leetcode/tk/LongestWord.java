package tk;

import java.util.*;

/**
 * 720. 词典中最长的单词
 * @author t.k
 * @date 2021/2/22 18:14
 */
public class LongestWord {

    public static String longestWord(String[] words) {
        Map<Integer, List<String>> temp = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            List<String> tempOrDefault = temp.getOrDefault(words[i].length(), new ArrayList<>());
            tempOrDefault.add(words[i]);
            temp.put(words[i].length(), tempOrDefault);
            maxLength = Math.max(maxLength, words[i].length());
        }
        for (int i = 1; i <= maxLength; i++) {
            List<String> strings = temp.get(i);
            if (strings == null) {
                break;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] words = {"w","a","wo","wor","worl", "world"};
        longestWord(words);
    }
}
