package tk.algorithm.sort;

import tk.algorithm.utils.Utils;

/**
 * 堆排序
 *
 * @author t.k
 * @date 2021/4/9 13:20
 */
public class HeapSort {

    public static void maxHeapify(int[] a, int heapSize, int i) {
        int left = i << 1;
        int right = left + 1;
        int largestIndex = i;
        if (left <= heapSize && a[i] > a[left]) {
            largestIndex = left;
        }
        if (right <= heapSize && a[largestIndex] > a[right]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            Utils.swap(a, largestIndex, i);
            maxHeapify(a, heapSize, largestIndex);
        }
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = (a.length - 1) >> 1; i > 0; i--) {
            maxHeapify(a, heapSize, i);
        }
    }

    public static void heapSort(int[] a) {
        int heapSize = a.length - 1;
        buildMaxHeap(a, heapSize);
        for (int i = a.length - 1; i > 1; i--) {
            Utils.swap(a, i, 1);
            heapSize--;
            maxHeapify(a, heapSize, 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 26, 5, 98, 108, 28, 99, 100, 56, 34, 1, -1, 3, 8, 12, 67, 6, 9, 11, 13};
//        int[] a = {-1, 5, 3, 17, 10, 84, 19, 6, 22, 9};
        heapSort(a);
        Utils.printArray(a);
    }
}
