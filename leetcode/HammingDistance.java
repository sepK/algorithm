/**
 * @author t.k
 * @date 2019/4/9 14:12
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        x = x^y;
        int sum = 0;
        while (x != 0) {
            x = x - (x & (-x));
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
