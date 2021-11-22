package tk.problem;

/**
 * @author t.k
 * @date 2021/4/22 10:42
 */
public class MyPow_50 {

    public static double myPow(double x, int n) {
        double result = x;
        double ans = 1.0d;
        long num = n;
        num = Math.abs(num);
        while (num > 0) {
            if (num % 2 == 1) {
                ans *= result;
            }
            result *= result;
            num <<= 1;
        }
        return n > 0 ? ans : 1.0d / ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
