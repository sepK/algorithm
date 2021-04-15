package tk;

/**
 * @author t.k
 * @date 2021/4/13 10:38
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1;i < strs.length;i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return prefix;
            }
        }

        return prefix;
    }
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
