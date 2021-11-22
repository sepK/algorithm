package tk.problem;

/**
 * @author t.k
 * @date 2021/4/25 11:10
 */
public class SumBase_5738 {
    public static int sumBase(int n, int k) {
        int result = 0;
        while (n > 0) {
            if (n % k != 0) {
                result += (n % k);
            }
            n /= k;
        }
        return result;
    }

    public static void main(String[] args) {
        sumBase(34, 6);
    }
}
