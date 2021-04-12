package tk.algorithm.sort;

/**
 * @author t.k
 * @date 2021/4/10 16:44
 */
public class RandomSelect {

    public static int randomSelect(int[] a, int left, int right, int i) {
        if (left == right) {
            return a[left];
        }
        int randomPartition = QuickSort.randomPartition(a, left, right);
        int k = randomPartition - left + 1;
        if (k == i) {
            return a[randomPartition];
        }
        if (i < k) {
            return randomSelect(a, left, randomPartition - 1, i);
        } else {
            return randomSelect(a, randomPartition + 1, right, i - k);
        }
    }
    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1, -1, 3, 8, 12, 67, 6, 9, 11, 13};
        //-1	1	3	5	6	8	9	11	12	13	26	28	34	56	67	98	99	100	108
        //查找第i个元素
        int randomSelect = randomSelect(a, 0, a.length - 1, 5);
        System.out.println(randomSelect);
    }
}
