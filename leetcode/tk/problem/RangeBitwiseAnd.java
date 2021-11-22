package tk.problem;

/**
 * @author t.k
 * @date 2020/11/20 18:25
 */
public class RangeBitwiseAnd {

    public static int rangeBitwiseAnd(int m, int n) {
        int lowM = Integer.highestOneBit(m);
        int lowN = Integer.highestOneBit(n);
        if (lowM == lowN) {
            return lowM;
        }
        while (lowN > lowM) {
            lowN -= Integer.highestOneBit(lowN);
        }

        if (lowM == lowN) {
            return lowM;
        }
        return 0;
    }


    public static void main(String[] args) {
        rangeBitwiseAnd(3,3);
    }
}
