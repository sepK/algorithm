package tk.algorithm.sort;

import tk.algorithm.utils.Utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 快速排序
 * <p>
 * 设计思路： 将数组的首元素作为key值 遍历整个数组 将小于key值的移到左边 大于key值的移到右边 递归调用
 *
 * @author t.k
 * @date 2021/4/9 10:47
 */
public class QuickSort {


    //算法导论视频方法
    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int partition = partition(a, left);
        partition = randomPartition(a, left, right);
        quickSort(a, left, partition);
        quickSort(a, partition + 1, right);
    }

    public static int partition(int[] a, int left) {
        int i = left, j = i + 1;
        int key = a[left];
        while (j < a.length && i + 1 < a.length) {
            if (key >= a[j]) {
                int temp = a[i + 1];
                a[i + 1] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        //交换key值
        a[left] = a[i];
        a[i] = key;
        return i;
    }

    public static int randomPartition(int[] a, int left, int right) {
        int i = left, j = i + 1;
        //随机化快排 key值取数组中随机的元素
        int randomKeyIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        int key = a[randomKeyIndex];
        Utils.swap(a, left, randomKeyIndex);
        while (j < a.length && i + 1 < a.length) {
            if (key >= a[j]) {
                Utils.swap(a, i + 1, j);
                i++;
            }
            j++;
        }
        //交换key值
        a[left] = a[i];
        a[i] = key;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1, -1, 3, 8, 12, 67, 6, 9, 11, 13};
        quickSort(a, 0, a.length - 1);
        Utils.printArray(a);
    }
}
