package tk.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t.k 929
 * @date 2019/4/8 14:25
 */
public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf('@');
            String prefix = email.substring(0, index);
            String suffix = email.substring(index, email.length());
            prefix = prefix.replace("", "");
            index = prefix.indexOf('+');
            if (index != -1) {
                prefix = prefix.substring(0, index);
            }
            set.add(prefix + suffix);
        }
        return set.size();
    }

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
