package tk;

/**
 * @author t.k
 * @date 2021/4/21 14:07
 */
public class MySqrt_69 {

    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        mySqrt(12);
    }
}
