package tk.algorithm.utils;

/**
 * @author t.k
 * @date 2021/4/15 10:11
 */
public class ArrayLogarithmGeneratorUtils {

    /**
     * 生成一个随机大小，最大数随机的数组
     *
     * @param maxSize 数组最大长度
     * @param maxNum  数组最大数
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxNum) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1)) - (int) (Math.random() * maxNum);
        }
        return arr;
    }


    /**
     * 判断两个数组是否完全相同
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null) {
            return false;
        }

        if (arr2 == null) {
            return false;
        }
        //长度不相等 肯定不相等
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //测试次数
        int testTimes = 10000;
        //最大测试容量
        int maxSize = 20;
        //最大测试数据
        int maxNum = 20;
        boolean euqals = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxNum);
            int[] arr2 = Utils.copyArray(arr1);
            if (!isEquals(arr1, arr2)) {
                euqals = false;
                break;
            }
        }
        System.out.println(euqals ? "Success:恭喜你！没毛病！" : "Error：抱歉，有错误");
        int[] newArr = generateRandomArray(maxSize, maxNum);
        Utils.printArray(newArr);
    }
}
