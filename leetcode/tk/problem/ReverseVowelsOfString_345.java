package tk.problem;

import java.util.Arrays;

/**
 * @author t.k
 * @date 2021/8/19 9:51
 */
public class ReverseVowelsOfString_345 {

    public static String reverseVowels(String words) {
        char[] temp = words.toCharArray();
        int left = 0;
        int right = temp.length - 1;
        while (left < right) {
            while (!isVowel(temp[left]) && left < right) {
                left++;
            }
            while (!isVowel(temp[right]) && left < right) {
                right--;
            }
            swap(temp, left, right);
            left++;
            right--;
        }
        return String.valueOf(temp);
    }

    public static Boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static void main(String[] args) {
        reverseVowels("hello");
    }
}
