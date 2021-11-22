package tk.problem;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author t.k
 * @date 2021/4/14 13:47
 */
public class MaxArea_11 {

    //O(N 2)
    public static int maxAreaTest(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (i > 1 && height[i] < height[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] h = new int[]{1, 2, 1};
        System.out.println(maxArea(h));
        h = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(h));
        h = new int[]{1, 1};
        System.out.println(maxArea(h));
        h = new int[]{4, 3, 2, 1, 4};
        System.out.println(maxArea(h));
    }
}
