/**
 * @author t.k 852
 * @date 2019/4/10 11:07
 */
public class PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] A) {
        int max = A[0];
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            } else {
                return i -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
