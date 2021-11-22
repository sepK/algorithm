package tk.problem;

import java.util.regex.Pattern;

/**
 * @author t.k
 * @date 2019/6/24 18:35
 */
public class HashCodeForTable {
    private static Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    public static boolean isInteger(String str){
        return pattern.matcher(str).matches();
    }
    public static int getTablePart(String teamId, int tablePartNum) {
        if (isInteger(teamId)){
            return Integer.parseInt(teamId) % tablePartNum;
        } else {
            int hashCode = teamId.hashCode();
            return Math.abs(hashCode) % tablePartNum;
        }
    }
    public static void main(String[] args) {
        String teamId = "111gc";
        System.out.println(getTablePart(teamId, 10));
    }
}
