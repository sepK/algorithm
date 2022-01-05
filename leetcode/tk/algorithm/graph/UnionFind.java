package tk.algorithm.graph;

/**
 * @author t.k
 * @date 2022/1/3 20:11
 */
public class UnionFind {
    private int[] parents;
    private int count;
    private int[] size;

    public void buildUnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return;
        }
        count--;
        if (size[parentX] > size[parentY]) {
            parents[y] = parentX;
            size[x] += size[y];
        } else {
            parents[x] = parentY;
            size[y] += size[x];
        }
    }

    public int find(int num) {
        while (parents[num] != num) {
            //todo 进行路径压缩 在理解下
            parents[num] = parents[parents[num]];
            num = parents[num];
        }
        return num;
    }

    public boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }
}
