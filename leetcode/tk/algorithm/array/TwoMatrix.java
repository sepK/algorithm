package tk.algorithm.array;

/**
 * @author t.k
 * @date 2022/1/9 9:48
 */
public class TwoMatrix {
    int[][] sums;

    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int i, int j, int x, int y) {
        return sums[x + 1][y + 1] - sums[i][y + 1] - sums[x + 1][j] + sums[i][j];
    }

    /**
     * 根据差分数组构造结果数组
     * 对二维差分矩阵求二维前缀和
     *
     * @param diff 差分矩阵
     */
    public void reverse(int[][] diff) {
        //滚动数组
        int n = diff.length;
        int[] cur = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cur[j + 1] = cur[j] + pre[j + 1] - pre[j] + diff[i][j];
            }
            int[] t = cur;
            cur = pre;
            pre = t;
        }

    }
}
