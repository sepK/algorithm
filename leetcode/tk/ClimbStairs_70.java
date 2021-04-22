package tk;

/**
 * @author t.k
 * @date 2021/4/20 16:14
 */
public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        int[] temp = new int[n + 3];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }

        return temp[n];
    }

    public static void main(String[] args) {
        int climbStairs = climbStairs(45);
        System.out.println(climbStairs);
    }
}
