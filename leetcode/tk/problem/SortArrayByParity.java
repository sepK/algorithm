package tk.problem;

/**
 * @author t.k 905
 * @date 2019/4/9 9:43
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right){
            if (A[left] % 2 != 0) {
                if (A[right] % 2 == 0) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                }
                right--;
            } else {
                left++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        sortArrayByParity(new int[]{3,1,4,2});
    }
}
