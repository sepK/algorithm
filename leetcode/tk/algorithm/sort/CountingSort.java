package tk.algorithm.sort;


import tk.algorithm.utils.Utils;

/**
 * 计数排序
 * 假设数组的是范围是 0-k 非负数
 * @author t.k
 * @date 2021/4/10 16:08
 */
public class CountingSort {


    private static void countingSort(int[] a, int[] b, int k) {
        int[] temp = new int[k + 1];
        for (int i = 0; i < a.length; i++) {
            temp[a[i]] = temp[a[i]] + 1;
        }
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        for (int i = 0; i < a.length; i++) {
            b[temp[a[i]]] = a[i];
            temp[a[i]]--;
        }
    }
    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1, 3, 8, 12, 67, 6, 9, 11, 13};
        int[] b = new int[a.length + 1];
        countingSort(a, b, 108);
        Utils.printArray(b);
    }
}
