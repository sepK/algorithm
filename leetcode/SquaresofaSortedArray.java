/**
 * @author t.k 977
 * @date 2019/4/8 15:13
 */
public class SquaresofaSortedArray {
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i]*A[i];
        }
        sortArrays(A, 0, A.length - 1);
        return A;
    }

    public static void sortArrays(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int key = A[l];
        while (l < r) {
            while (l < r && A[r] >= key) {
                r--;
            }
            A[l] = A[r];
            while (l < r && A[l] <= key) {
                l++;
            }
            A[r] = A[l];
        }
        A[l] = key;
        sortArrays(A, left, l - 1);
        sortArrays(A, r + 1, right);
    }

    public static void main(String[] args) {
        sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
