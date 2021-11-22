package tk.problem;

/**
 * 917. 仅仅反转字母
 *
 * @author t.k
 * @date 2021/2/22 15:26
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        for (int i = 0, k = chars.length - 1; i < chars.length && k > 0; i++, k--) {
            int nextLetterIndex = getNextLetterIndex(chars, i);
            int reverseLetterIndex = getReverseLetterIndex(chars, k);
            //边界
            if (nextLetterIndex > chars.length - 1 || reverseLetterIndex < 0 || nextLetterIndex >= reverseLetterIndex) {
                break;
            }
            //交换
            char temp = chars[nextLetterIndex];
            chars[nextLetterIndex] = chars[reverseLetterIndex];
            chars[reverseLetterIndex] = temp;
            i = nextLetterIndex;
            k = reverseLetterIndex;
        }
        return String.valueOf(chars);
    }

    private static int getNextLetterIndex(char[] chars, int i) {
        if (i > chars.length - 1) {
            return i;
        }
        if (isLetter(chars[i])) {
            return i;
        }
        return getNextLetterIndex(chars, ++i);
    }

    private static int getReverseLetterIndex(char[] chars, int i) {
        if (i < 0) {
            return i;
        }
        if (isLetter(chars[i])) {
            return i;
        }
        return getReverseLetterIndex(chars, --i);
    }

    private static boolean isLetter(char letter) {
        return (letter >= 97 && letter <= 122) || (letter >= 65 && letter <= 90);
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        String reverseOnlyLetters = reverseOnlyLetters(s);
        System.out.println(reverseOnlyLetters);
    }
}
