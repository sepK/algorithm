import java.util.ArrayList;
import java.util.List;

/**
 * @author t.k
 * @date 2019/4/10 10:04
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            if (isSelfDividingNumber(left)) {
                list.add(left);
            }
            left++;
        }
        return list;
    }
    public static boolean isSelfDividingNumber(int number) {
        int temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            if (digit == 0 || number % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        selfDividingNumbers(1, 22);
    }
}
