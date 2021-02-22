package tk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t.k 771
 * @date 2019/4/8 11:15
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            } else {
                map.put(S.charAt(i), 1);
            }
        }
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            if (map.containsKey(J.charAt(i))) {
                num += map.get(J.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("a", "abbbba"));
    }
}
