package tk.problem;

/**
 * @author t.k
 * @date 2021/4/19 10:35
 */
public class StrStr_28 {

    public static int strStr1(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int[] next = new int[haystack.length() + 1];
        getNext(needle, next);
        int i = 0, k = 0;
        while (i < haystack.length()) {
            if (k == -1 || haystack.charAt(i) == needle.charAt(k)) {
                i++;
                k++;
            } else {
                k = next[k];
            }
            if (k >= needle.length()) {
                return i - k;
            }
        }
        return -1;
    }

    public static void getNext(String haystack, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < haystack.length()) {
            if (j == -1 || haystack.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                // 如果s[i]!=s[j]说明匹配失败, 回到上一级公共前后缀处
                j = next[j];
            }
        }
    }


    public static void main(String[] args) {
        strStr1("mississippi", "issip");
    }
}
