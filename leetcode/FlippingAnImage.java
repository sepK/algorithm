/**
 * @author t.k 832
 * @date 2019/4/9 11:17
 */
public class FlippingAnImage {
    //[[1,1,0],[1,0,1],[0,0,0]]
    //[[1,0,0],[0,1,0],[1,1,1]]

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int index = 0; index < A.length; index++) {
            int left = 0;
            int right = A[index].length - 1;
            while (left < right) {
                if (A[index][left] == A[index][right]) {
                    A[index][left] = (A[index][left] + 1) % 2;
                    A[index][right] = (A[index][right] + 1) % 2;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[index][left] = (A[index][left] + 1) % 2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
}
