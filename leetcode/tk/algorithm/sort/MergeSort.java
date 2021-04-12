package tk.algorithm.sort;

import utils.Utils;

/**
 * 归并排序
 * @author t.k
 * @date 2021/4/9 4:18
 */
public class MergeSort {

    private static void mergeSort(int[] a, int left, int right, int[] finalArrays) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(a, left, mid, finalArrays);
        mergeSort(a, mid + 1, right, finalArrays);
        merge(a, left, mid, right, finalArrays);
    }

    private static void merge(int[] a, int left, int mid, int right, int[] finalArrays) {
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1]) {
                finalArrays[tIndex++] = a[left++];
            } else {
                finalArrays[tIndex++] = a[r1++];
            }
        }

        // 将左边剩余的归并
        while (left <= mid) {
            finalArrays[tIndex++] = a[left++];
        }

        // 将右边剩余的归并
        while (r1 <= right) {
            finalArrays[tIndex++] = a[r1++];
        }

        //从临时数组拷贝到原数组
        while (cIndex <= right) {
            a[cIndex] = finalArrays[cIndex];
            //输出中间归并排序结果
            System.out.print(a[cIndex] + "\t");
            cIndex++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1, -1, 3, 8, 12, 67};
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
        Utils.printArray(a);
    }
}
