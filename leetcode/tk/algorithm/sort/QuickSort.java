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
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int partition = partition(a, left);
        partition = randomPartition(a, left, right);
        quickSort(a, left, partition);
        quickSort(a, partition + 1, right);
    }

    /**
     * 1、选择当前的left位置作为主元
     * 2、和后续的范围的值进行比较 设i = left, j = i + 1;
     * 2.1、当主元大于num[j] 交换i + 1 和 j 位置的数值 i++,j++;
     * 2.2、当主元小于等于num[j] j++;
     * 3、交换 left 和 i 位置上的数;
     */
    public static int partition(int[] a, int left) {
        int i = left, j = i + 1;
        int key = a[left];
        while (j < a.length && i + 1 < a.length) {
            if (key > a[j]) {
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
        int randomKeyIndex = 0;
        try {
            randomKeyIndex = ThreadLocalRandom.current().nextInt(left, right);
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            //小于主元的值和less位置的值交换
            if (arr[L] < p) {
                Utils.swap(arr, ++less, L++);
            } else if (arr[L] > p) {
                //大于主元的值和more位置的值交换
                Utils.swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 5, 4, 3, 2, 1};
        quickSort(a, 0, a.length - 1);
        Utils.printArray(a);
    }
}
