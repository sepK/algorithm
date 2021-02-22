/**
 * @author t.k
 * @date 2020/5/30 17:23
 */
public class IntReverse {
    public static int reverse(int x) {
        long num = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            num = num * 10 + temp;
        }
        if (num <= Integer.MIN_VALUE) {
            return 0;
        }
        if (num >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int) num;
    }
    public static void main(String[] args) {
        int reverse = reverse(-123);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
    }
}
