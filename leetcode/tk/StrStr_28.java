package tk;

/**
 * @author t.k
 * @date 2021/4/19 10:35
 */
public class StrStr_28 {

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int[] next = new int[haystack.length() + 1];
        getNext1(haystack, next);
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

    public static void getNext1(String haystack, int[] next) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != haystack.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == haystack.charAt(j)) {
                j++;
            }
            //更新next数组
            next[i] = j;
        }
    }


    public static void main(String[] args) {
        //todo 有bug
        strStr("mississippi", "issip");
    }
}
