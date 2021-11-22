package tk.problem;

/**
 * @author t.k
 * @date 2021/4/23 9:58
 */
public class FindCircleNum_547 {

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null) {
            return 0;
        }
        int ans = 0;
        int size = isConnected.length;
        int[] unionSet = new int[size];
        for (int i = 0; i < size; i++) {
            unionSet[i] = i;
        }
        for (int i = 0; i < size; i++) {
            for (int k = i + 1; k < size; k++) {
                if (isConnected[i][k] == 1) {
                    unionSet(unionSet, i, k);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (unionSet[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    public static int findSet(int[] unionSet, int value) {
        if (unionSet[value] == value) {
            return value;
        }
        unionSet[value] = findSet(unionSet, unionSet[value]);
        return unionSet[value];
    }

    public static void unionSet(int[] unionSet, int x, int y) {
        int parentX = findSet(unionSet, x);
        int parentY = findSet(unionSet, y);
        if (parentX == parentY) {
            return;
        }
        unionSet[parentY] = parentX;
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        findCircleNum(isConnected);
    }
}
