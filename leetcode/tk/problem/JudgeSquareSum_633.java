package tk.problem;

/**
 * @author t.k
 * @date 2021/4/28 9:51
 */
public class JudgeSquareSum_633 {

    public static boolean judgeSquareSum(int c) {
        for (int i = 0;i <= Math.sqrt(c) + 1;i++) {
            int b = (int) Math.sqrt(c - i * i);
            if (b * b + i *i == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        judgeSquareSum(4);
    }
}
