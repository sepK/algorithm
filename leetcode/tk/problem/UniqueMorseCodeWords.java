package tk.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t.k 804
 * @date 2019/4/8 11:37
 */
public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] string = {".-","-...","-.-.","-..", "","..-.","--.","....", "",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stringBuilder.append(string[word.charAt(i) - 97]);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
    }
}
