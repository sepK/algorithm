package tk.problem;

/**
 * @author t.k
 * @date 2020/5/30 18:16
 */
public class IsPalindrome {
    public static boolean Solution(int x) {
        if (x < 0) {
            return false;
        }
        long num = 0;
        int tempX = x;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            num = num * 10 + temp;
        }
        if (tempX == (int) num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean solution = Solution(10);
        System.out.println(solution);
    }
}
