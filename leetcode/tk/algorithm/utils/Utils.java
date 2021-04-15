package tk.algorithm.utils;

/**
 * @author t.k
 * @date 2021/4/9 13:29
 */
public class Utils {

    /**
     * 数组交换
     * @param array
     * @param left
     * @param right
     */
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * 打印数组
     * @param a
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 复制当前数组的一个样本
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }
}
