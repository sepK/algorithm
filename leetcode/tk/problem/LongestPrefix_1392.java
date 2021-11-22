package tk.problem;

/**
 * @author t.k
 * @date 2021/4/29 15:54
 */
public class LongestPrefix_1392 {

    public static String longestPrefix(String s) {
        int[] next = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        getNext(chars, next);
        int l = s.length();
        return s.substring(s.length() - next[l], l);
    }


    private static void getNext(char[] chars, int[] next) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < chars.length) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("leetcodeleetr"));
    }
}
