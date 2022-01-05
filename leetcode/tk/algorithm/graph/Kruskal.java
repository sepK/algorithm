package tk.algorithm.graph;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最小生成树
 *
 * @author t.k
 * @date 2022/1/5 9:48
 */
public class Kruskal {
    /**
     * 判断输入的若干条边是否能构造出一棵树结构
     *
     * @param n
     * @param edges
     * @return
     */
    boolean validTree(int n, int[][] edges) {
        // 初始化 0...n-1 共 n 个节点
        UnionFind unionFind = new UnionFind(n);
        //按照权重排序
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        // 遍历所有边，将组成边的两个节点进行连接
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // 若两个节点已经在同一连通分量中，会产生环
            if (unionFind.connected(u, v)) {
                return false;
            }
            // 这条边不会产生环，可以是树的一部分
            unionFind.union(u, v);
        }
        // 要保证最后只形成了一棵树，即只有一个连通分量
        return unionFind.count() == 1;
    }

    static class UnionFind {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的「重量」
        private int[] size;

        // n 为图中节点的个数
        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            // 两个连通分量合并成一个连通分量
            count--;
        }

        // 判断节点 p 和节点 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        // 返回节点 x 的连通分量根节点
        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }
}
